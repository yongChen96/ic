package com.example.security.service;

import com.example.common.constant.GlobalConstant;
import com.example.common.exception.CaptchaException;
import com.example.common.exception.CaptchaExpireException;
import com.example.common.exception.CustomException;
import com.example.common.exception.UserPasswordNotMatchException;
import com.example.common.utils.MessageUtils;
import com.example.security.config.async.AsyncFactory;
import com.example.security.config.async.AsyncManager;
import com.example.security.config.handle.TokenService;
import com.example.security.config.redis.RedisCache;
import com.example.security.entity.LoginUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: LoginService
 * @Description: 登录校验方法
 * @Author hzy
 * @Date 2020/8/11 15:57
 **/
@Component
public class LoginService {

    @Resource
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;

    /**
     * 登录校验
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     随机码
     * @return token
     */
    public String login(String username, String password, String code, String uuid) {
        String verifyKey = GlobalConstant.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            AsyncManager.me().execute(AsyncFactory.recordLoginInfo(username, GlobalConstant.LOGIN_FAIL, MessageUtils.message("user.captcha.expire")));
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            AsyncManager.me().execute(AsyncFactory.recordLoginInfo(username, GlobalConstant.LOGIN_FAIL, MessageUtils.message("user.captcha.error")));
            throw new CaptchaException();
        }
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                AsyncManager.me().execute(AsyncFactory.recordLoginInfo(username, GlobalConstant.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            } else {
                AsyncManager.me().execute(AsyncFactory.recordLoginInfo(username, GlobalConstant.LOGIN_FAIL, e.getMessage()));
                throw new CustomException(e.getMessage());
            }
        }
        AsyncManager.me().execute(AsyncFactory.recordLoginInfo(username, GlobalConstant.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return tokenService.createToken(loginUser);
    }
}
