package com.example.common.exception;

/**
 * @ClassName: UtilException
 * @Description: 工具类异常
 * @Author hzy
 * @Date 2020/8/10 16:21
 **/
public class UtilException extends RuntimeException {
    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(Throwable e) {
        super(e.getMessage(), e);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
