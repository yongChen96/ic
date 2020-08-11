package com.example.security.mapper;

import com.example.security.entity.OperateLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 操作日志记录 Mapper 接口
 * </p>
 *
 * @author hyd
 * @since 2020-08-11
 */
@Mapper
public interface OperateLogMapper extends BaseMapper<OperateLog> {

}
