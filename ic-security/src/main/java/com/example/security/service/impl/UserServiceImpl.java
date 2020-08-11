package com.example.security.service.impl;

import com.example.security.entity.User;
import com.example.security.entity.vo.UserVO;
import com.example.security.mapper.UserMapper;
import com.example.security.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVO selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }
}
