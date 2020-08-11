package com.example.security.service.impl;

import com.example.common.utils.StringUtils;
import com.example.security.entity.SysResource;
import com.example.security.mapper.ResourceMapper;
import com.example.security.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, SysResource> implements ResourceService {

    @Resource
    private ResourceMapper resourceMapper;

    @Override
    public Set<String> selectResourcePermsByUserId(String id) {
        List<String> perms = resourceMapper.selectResourceByUserId(id);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}
