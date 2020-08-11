package com.example.security.mapper;

import com.example.security.entity.LoginInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统访问记录 Mapper 接口
 * </p>
 *
 * @author hyd
 * @since 2020-08-11
 */
@Repository
public interface LoginInfoMapper extends BaseMapper<LoginInfo> {

}
