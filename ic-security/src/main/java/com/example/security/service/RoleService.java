package com.example.security.service;

import com.example.security.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户id获取用户权限
     *
     * @param id 用户id
     * @return set
     */
    public Set<String> selectRolePermissionByUserId(String id);
}
