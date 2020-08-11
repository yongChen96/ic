package com.example.system.controller;

import com.example.common.config.mybatisplus.superclass.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: LoginInfoController
 * @Description: 登录日志 前端控制器
 * @Author hzy
 * @Date 2020/8/11 11:31
 **/
@RestController
@RequestMapping("/loginInfo")
@Api(value = "LoginInfoController", tags = "登录日志记录")
public class LoginInfoController extends BaseController {
}
