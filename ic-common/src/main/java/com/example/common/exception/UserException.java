package com.example.common.exception;

/**
 * @ClassName: UserException
 * @Description: 用户信息异常类
 * @Author hzy
 * @Date 2020/8/11 16:16
 **/
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
