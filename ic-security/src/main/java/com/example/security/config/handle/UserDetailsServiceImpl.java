package com.example.security.config.handle;

import com.example.common.enums.UserStatus;
import com.example.common.exception.BaseException;
import com.example.common.utils.StringUtils;
import com.example.security.entity.User;
import com.example.security.service.UserRoleService;
import com.example.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: userDetailsServiceImpl
 * @Description: 用户校验
 * @Author: hyd
 * @Date: 2020/8/10 17:36
 **/
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;
    @Resource
    private com.example.security.entity.Resource resource;
    @Resource
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.selectByUserName(userName);
        if (StringUtils.isNull(user)) {
            log.info("登录用户：{} 不存在.", userName);
            throw new UsernameNotFoundException("登录用户：" + userName + " 不存在");
        } else if (UserStatus.DELETED.getCode().equals(user.getAccStatus())) {
            log.info("登录用户：{} 已被删除.", userName);
            throw new BaseException("对不起，您的账号：" + userName + " 已被删除");
        } else if (UserStatus.DISABLE.getCode().equals(user.getAccStatus())) {
            log.info("登录用户：{} 已被停用.", userName);
            throw new BaseException("对不起，您的账号：" + userName + " 已停用");
        }

        return createLoginUser(user);
    }
    public UserDetails createLoginUser(User user) {
        return new LoginUser(sysUser, resource.getMenuPermission(sysUser));
    }
}
