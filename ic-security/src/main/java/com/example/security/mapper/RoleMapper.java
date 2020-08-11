package com.example.security.mapper;

import com.example.security.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户ID查询角色
     *
     * @param id 用户id
     * @return list
     */
    List<Role> selectRolePermissionByUserId(String id);
}
