package com.example.common.exception;

/**
 * @ClassName: CaptchaException
 * @Description: 验证码错误异常类
 * @Author hzy
 * @Date 2020/8/11 16:19
 **/
public class CaptchaException extends UserException {
    private static final long serialVersionUID = 1L;

    public CaptchaException() {
        super("user.captcha.error", null);
    }
}
