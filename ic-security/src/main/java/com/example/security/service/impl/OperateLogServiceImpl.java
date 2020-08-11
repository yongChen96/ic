package com.example.security.service.impl;

import com.example.security.entity.OperateLog;
import com.example.security.mapper.OperateLogMapper;
import com.example.security.service.OperateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author hyd
 * @since 2020-08-11
 */
@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {
    @Resource
    private OperateLogMapper operateLogMapper;

    @Override
    public void insertOperateLog(OperateLog operateLog) {
        operateLogMapper.insert(operateLog);
    }
}
