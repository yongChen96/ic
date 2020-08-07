package com.example.common.config.mybatisplus.superclass;

import com.example.common.rest.Result;

/**
 * @ClassName: BaseController
 * @Description: Controller父类
 * @Author: yongchen
 * @Date: 2020/8/5 14:14
 **/
public abstract class BaseController {
    public BaseController() {
    }

    /**
     * @Author: yongchen
     * @Description: 接口成功无参数返回
     * @Date: 17:06 2020/8/5
     * @Param: []
     * @return: com.example.iccommon.rest.Result<T>
     **/
    public <T> Result<T> success() {
        return Result.success();
    }

    /**
     * @Author: yongchen
     * @Description: 接口成功有参数返回
     * @Date: 17:03 2020/8/5
     * @Param: [data]
     * @return: com.example.iccommon.rest.Result<T>
     **/
    public <T> Result<T> success(T data) {
        return Result.success(data);
    }

    /**
     * @Author: yongchen
     * @Description: 接口失败无参数返回
     * @Date: 17:07 2020/8/5
     * @Param: []
     * @return: com.example.iccommon.rest.Result<T>
     **/
    public <T> Result<T> fail() {
        return Result.fail();
    }

    /**
     * @Author: yongchen
     * @Description: 接口失败重置失败信息
     * @Date: 17:07 2020/8/5
     * @Param: [msg]
     * @return: com.example.iccommon.rest.Result<T>
     **/
    public <T> Result<T> fail(String msg) {
        return Result.fail(msg);
    }
}