package com.example.security.service;

import com.example.security.entity.LoginInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统访问记录 服务类
 * </p>
 *
 * @author hyd
 * @since 2020-08-11
 */
public interface LoginInfoService extends IService<LoginInfo> {

    /**
     * 新增系统登录日志
     *
     * @param loginInfo 登录日志实体
     */
    public void insertLoginInfo(LoginInfo loginInfo);
}
