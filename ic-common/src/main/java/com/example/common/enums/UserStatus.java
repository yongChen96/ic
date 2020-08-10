package com.example.common.enums;

/**
 * @ClassName: UserStatus
 * @Description: 用户状态
 * @Author hzy
 * @Date 2020/8/10 16:32
 **/
public enum UserStatus {
    /**
     * 正常
     */
    OK("0", "正常"),
    /**
     * 冻结
     */
    DISABLE("1", "冻结"),
    /**
     * 注销
     */
    DELETED("2", "注销");

    private final String code;
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
