package com.example.common.rest;

import com.example.common.enums.ResultEnum;
import lombok.Data;

/**
 * @ClassName: Result
 * @Description: 统一返回实体
 * @Author: yongchen
 * @Date: 2020/8/5 16:36
 **/
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(String msg) {
        this.code = ResultEnum.SUCCESS_CODE.getCode();
        this.msg = msg;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <E> Result<E> success() {
        return new Result(ResultEnum.SUCCESS_CODE.getCode(), ResultEnum.SUCCESS_CODE.getMsg());
    }

    public static <E> Result<E> success(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static <E> Result<E> success(E data) {
        return new Result(ResultEnum.SUCCESS_CODE.getCode(), ResultEnum.SUCCESS_CODE.getMsg(), data);
    }

    public static <E> Result<E> success(Integer code, String msg, E data) {
        return new Result(code, msg, data);
    }

    public static <E> Result<E> fail() {
        return new Result(ResultEnum.SUCCESS_FAIL.getCode(), ResultEnum.SUCCESS_FAIL.getMsg());
    }

    public static <E> Result<E> fail(String msg) {
        return new Result(msg);
    }

    public static <E> Result<E> fail(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static <E> Result<E> fail(E data) {
        return new Result(ResultEnum.SUCCESS_FAIL.getCode(), ResultEnum.SUCCESS_FAIL.getMsg(), data);
    }

    public static <E> Result<E> fail(Integer code, String msg, E data) {
        return new Result(code, msg, data);
    }

    public static <E> Result<E> result(Integer code, String msg) {
        return new Result(code, msg);
    }
}
