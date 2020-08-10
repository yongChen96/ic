package com.example.security.config.handle;

import com.example.security.service.RoleService;
import com.example.security.service.UserRoleService;
import com.example.security.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: userDetailsServiceImpl
 * @Description: 用户校验
 * @Author: yongchen
 * @Date: 2020/8/7 14:37
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
