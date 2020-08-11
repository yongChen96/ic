package com.example.common.exception;

/**
 * @ClassName: CaptchaExpireException
 * @Description: 验证码失效异常类
 * @Author hzy
 * @Date 2020/8/11 16:15
 **/
public class CaptchaExpireException extends  UserException{
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException() {
        super("user.captcha.expire", null);
    }
}
