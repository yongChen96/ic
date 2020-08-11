package com.example.security.service.impl;

import com.example.common.utils.StringUtils;
import com.example.security.entity.Role;
import com.example.security.mapper.RoleMapper;
import com.example.security.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public Set<String> selectRolePermissionByUserId(String id) {
        List<Role> perms = roleMapper.selectRolePermissionByUserId(id);
        Set<String> permsSet = new HashSet<>();
        for (Role perm : perms) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRoleCode().trim().split(",")));
            }
        }
        return permsSet;
    }
}
