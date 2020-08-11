package com.example.security.config.handle;

import com.alibaba.fastjson.JSON;
import com.example.common.constant.GlobalConstant;
import com.example.common.rest.Result;
import com.example.common.utils.HttpStatus;
import com.example.common.utils.ServletUtils;
import com.example.common.utils.StringUtils;
import com.example.security.config.async.AsyncFactory;
import com.example.security.config.async.AsyncManager;
import com.example.security.entity.LoginUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LogoutSuccessHandlerImpl
 * @Description: 自定义退出处理类 返回成功
 * @Author hzy
 * @Date 2020/8/11 10:12
 **/
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    @Resource
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)) {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLoginInfo(userName, GlobalConstant.LOGOUT, "退出成功"));
        }
        ServletUtils.renderString(response, JSON.toJSONString(Result.success(HttpStatus.SUCCESS, "退出成功")));
    }
}
