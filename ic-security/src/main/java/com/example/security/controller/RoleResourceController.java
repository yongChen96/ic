package com.example.security.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.common.config.mybatisplus.superclass.BaseController;
import io.swagger.annotations.Api;

/**
 * <p>
 * 角色资源信息表 前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/role-resource")
@Api(value = "RoleResourceController", description = "角色资源信息表")
public class RoleResourceController extends BaseController {

}
