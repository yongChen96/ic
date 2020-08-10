package com.example.common.enums;

/**
 * @ClassName: ResultEnum
 * @Description: 系统全局code&msg枚举类
 * @Author: yongchen
 * @Date: 2020/8/5 16:37
 **/
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS_CODE(0, "success"),
    /**
     * 失败
     */
    SUCCESS_FAIL(-1, "fail");


    private Integer code;
    private String msg;

    private ResultEnum() {
    }

    private ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
