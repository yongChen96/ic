package com.example.security.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.common.config.mybatisplus.superclass.BaseController;
import io.swagger.annotations.Api;

/**
 * <p>
 * 系统访问记录 前端控制器
 * </p>
 *
 * @author hyd
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/loginingo")
@Api(value = "LoginingoController", description = "系统访问记录")
public class LoginingoController extends BaseController {

}
