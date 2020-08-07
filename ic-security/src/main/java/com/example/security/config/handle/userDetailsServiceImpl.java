package com.example.security.config.handle;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.security.entity.Role;
import com.example.security.entity.User;
import com.example.security.entity.UserRole;
import com.example.security.service.RoleService;
import com.example.security.service.UserRoleService;
import com.example.security.service.UserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: userDetailsServiceImpl
 * @Description: 用户校验
 * @Author: yongchen
 * @Date: 2020/8/7 14:37
 **/
@Service
public class userDetailsServiceImpl implements UserDetailsService{

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(new User().getNickName(), s);
        User user = userService.getOne(queryWrapper);
        if(null == user){
            throw new UsernameNotFoundException("用户不存在");
        }
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq(new UserRole().getUserId(), user.getId());
        List<UserRole> list = userRoleService.list(userRoleQueryWrapper);
        List<String> roleList = list.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());
        List<Role> roles = roleService.listByIds(roleList);
        for (Role role : roles) {

        }
        return new org.springframework.security.core.userdetails.User(user.getNickName(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
    }
}
