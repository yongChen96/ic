package com.example.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.common.config.mybatisplus.superclass.BaseController;
import io.swagger.annotations.Api;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@RestController
@RequestMapping("/resource")
@Api(value = "ResourceController", description = "资源表")
public class ResourceController extends BaseController {

}
