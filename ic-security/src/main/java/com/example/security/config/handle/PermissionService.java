package com.example.security.config.handle;

import com.example.security.entity.User;
import com.example.security.entity.vo.UserVO;
import com.example.security.service.ResourceService;
import com.example.security.service.RoleService;
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
    private ResourceService resourceService;

    @Resource
    private RoleService roleService;

    /**
     * 获取资源数据权限
     *
     * @param userVO 用户实体
     * @return set
     */
    public Set<String> getRolesPermission(UserVO userVO) {
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (userVO.isAdmin()) {
            perms.add("*:*:*");
        } else {
            perms.addAll(resourceService.selectResourcePermsByUserId(userVO.getId()));
        }
        return perms;
    }
}
