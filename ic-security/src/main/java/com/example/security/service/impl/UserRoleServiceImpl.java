package com.example.security.service.impl;

import com.example.security.entity.UserRole;
import com.example.security.mapper.UserRoleMapper;
import com.example.security.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author yongchen
 * @since 2020-08-07
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
