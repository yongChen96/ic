package com.example.security.controller;

import com.example.common.annotation.Log;
import com.example.common.config.mybatisplus.superclass.BaseController;
import com.example.common.constant.GlobalConstant;
import com.example.common.enums.BusinessType;
import com.example.common.rest.Result;
import com.example.security.entity.LoginBody;
import com.example.security.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: 登录验证
 * @Author hzy
 * @Date 2020/8/11 15:53
 **/
@Api(value = "登录校验", tags = "登录校验")
@RestController
@RequestMapping(value = "/system/login")
public class LoginController extends BaseController {
    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "登录")
    public Result<Map<String, Object>> login(@RequestBody LoginBody loginBody) {
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        Map<String, Object> map = new HashMap<>(16);
        map.put(GlobalConstant.TOKEN, token);
        return success(map);
    }
}
