package com.example.security.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName: LoginBody
 * @Description: 用户登录对象
 * @Author hzy
 * @Date 2020/8/11 15:59
 **/
@Data
@Accessors(chain = true)
@ApiModel(value = "LoginInfo对象", description = "用户登录对象")
public class LoginBody {
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid = "";
}
