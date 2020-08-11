package com.example.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.common.config.mybatisplus.superclass.BaseController;
import io.swagger.annotations.Api;

/**
 * <p>
 * 操作日志记录 前端控制器
 * </p>
 *
 * @author hyd
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/operateLog")
@Api(value = "OperateLogController", tags = "操作日志记录")
public class OperateLogController extends BaseController {

}
