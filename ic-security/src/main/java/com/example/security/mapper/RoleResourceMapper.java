package com.example.security.mapper;

import com.example.security.entity.RoleResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色资源信息表 Mapper 接口
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Mapper
public interface RoleResourceMapper extends BaseMapper<RoleResource> {

}
