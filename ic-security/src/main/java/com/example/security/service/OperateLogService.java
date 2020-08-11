package com.example.security.service;

import com.example.security.entity.OperateLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 操作日志记录 服务类
 * </p>
 *
 * @author hyd
 * @since 2020-08-11
 */
public interface OperateLogService extends IService<OperateLog> {
    /**
     * 新增操作日志
     *
     * @param operateLog 操作日志实体
     */
    public void insertOperateLog(OperateLog operateLog);
}
