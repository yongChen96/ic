package com.example.security.config.handle;

import com.example.security.entity.User;
import com.example.security.entity.vo.UserVO;
import com.example.security.service.ResourceService;
import com.example.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: PermissionService
 * @Description: 用户权限处理
 * @Author hzy
 * @Date 2020/8/11 8:40
 **/
@Component
public class PermissionService {
    @Resource
    private RoleService roleService;

    @Resource
    private ResourceService resourceService;

    /**
     * 获取角色数据权限
     *
     * @param user 用户信息
     * @return 角色权限信息
     */
    public Set<String> getRolePermission(UserVO user) {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin()) {
            roles.add("admin");
        } else {
            roles.addAll(roleService.selectRolePermissionByUserId(user.getId()));
        }
        return roles;
    }

    /**
     * 获取资源数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getResourcesPermission(UserVO user) {
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin()) {
            perms.add("*:*:*");
        } else {
            perms.addAll(resourceService.selectResourcePermsByUserId(user.getId()));
        }
        return perms;
    }
}
