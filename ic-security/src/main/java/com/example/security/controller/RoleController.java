package com.example.security.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.page.PageParam;
import com.example.common.rest.Result;
import com.example.security.entity.Role;
import com.example.security.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.example.common.config.mybatisplus.superclass.BaseController;
import io.swagger.annotations.Api;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author yongchen
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/role")
@Api(value = "RoleController", tags = "角色表")
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    /**
     * @Author: yongchen
     * @Description: 获取角色分页列表
     * @Date: 13:58 2020/8/7
     * @Param: [pp]
     * @return: com.example.common.rest.Result
     **/
    @PostMapping("/page")
    @ApiOperation(value = "获取角色分页列表", notes = "获取角色分页列表")
    public Result page(@RequestBody PageParam<Role> pp){
        Page<Role> page = pp.getPage();
        Role data = pp.getData();
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>(data);
        IPage<Role> rolePage = roleService.page(page, queryWrapper);
        return success(rolePage);
    }
}
