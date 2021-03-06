package com.example.security.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.common.config.mybatisplus.superclass.BaseController;
import io.swagger.annotations.Api;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@RestController
@RequestMapping("/role")
@Api(value = "RoleController", tags = "角色表")
public class RoleController extends BaseController {

}
