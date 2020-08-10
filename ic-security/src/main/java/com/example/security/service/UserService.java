package com.example.security.service;

import com.example.security.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
public interface UserService extends IService<User> {
    /**
     * 根据用户明查询用户信息
     *
     * @param username 用户名
     * @return sysUser
     */
    User selectByUserName(String username);
}
