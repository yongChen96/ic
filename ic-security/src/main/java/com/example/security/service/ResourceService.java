package com.example.security.service;

import com.example.security.entity.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
public interface ResourceService extends IService<SysResource> {

    /**
     * 根据用户ID查询权限
     *
     * @param id 用户id
     * @return set
     */
    public Set<String> selectResourcePermsByUserId(String id);
}
