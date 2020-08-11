package com.example.security.mapper;

import com.example.security.entity.SysResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author hyd
 * @since 2020-08-10
 */
@Mapper
public interface ResourceMapper extends BaseMapper<SysResource> {

    /**
     * 根据用户id查询权限
     * @param id
     * @return
     */
    List<String> selectResourceByUserId(String id);
}
