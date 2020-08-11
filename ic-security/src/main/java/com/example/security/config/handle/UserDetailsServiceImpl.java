package com.example.security.config.handle;

import com.example.common.enums.UserStatus;
import com.example.common.exception.BaseException;
import com.example.common.utils.StringUtils;
import com.example.security.entity.LoginUser;
import com.example.security.entity.User;
import com.example.security.entity.vo.UserVO;
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
    private PermissionService permissionService;
    @Resource
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserVO userVO = userService.selectByUserName(userName);
        if (StringUtils.isNull(userVO)) {
            log.info("登录用户：{} 不存在.", userName);
            throw new UsernameNotFoundException("登录用户：" + userName + " 不存在");
        }
        if (UserStatus.DELETED.getCode().equals(userVO.getAccStatus())) {
            log.info("登录用户：{} 已被删除.", userName);
            throw new BaseException("对不起，您的账号：" + userName + " 已被删除");
        }
        if (UserStatus.DISABLE.getCode().equals(userVO.getAccStatus())) {
            log.info("登录用户：{} 已被停用.", userName);
            throw new BaseException("对不起，您的账号：" + userName + " 已停用");
        }

        return createLoginUser(userVO);
    }

    public UserDetails createLoginUser(UserVO userVO) {
        return new LoginUser(userVO, permissionService.getResourcesPermission(userVO));
    }
}
