package com.example.security.service.impl;

import com.example.security.entity.LoginInfo;
import com.example.security.mapper.LoginInfoMapper;
import com.example.security.service.LoginInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author hyd
 * @since 2020-08-11
 */
@Service
public class LoginInfoServiceImpl extends ServiceImpl<LoginInfoMapper, LoginInfo> implements LoginInfoService {
    @Resource
    private LoginInfoMapper loginInfoMapper;

    @Override
    public void insertLoginInfo(LoginInfo loginInfo) {
        loginInfoMapper.insert(loginInfo);
    }
}
