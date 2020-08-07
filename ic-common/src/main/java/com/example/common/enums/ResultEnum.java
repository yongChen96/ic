package com.example.common.enums;

/**
 * @ClassName: ResultEnum
 * @Description: 系统全局code&msg枚举类
 * @Author: yongchen
 * @Date: 2020/8/5 16:37
 **/
public enum ResultEnum {

    SUCCESS_CODE("0","success"),
    SUCCESS_FAIL("-1","fail");



    private String code;
    private String msg;

    private ResultEnum(){}
    private ResultEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
