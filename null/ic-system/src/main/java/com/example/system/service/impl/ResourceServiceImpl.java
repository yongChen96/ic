package com.example.security.service.impl;

import com.example.security.entity.Resource;
import com.example.security.mapper.ResourceMapper;
import com.example.security.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

}
