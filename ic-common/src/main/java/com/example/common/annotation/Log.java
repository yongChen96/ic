package com.example.common.annotation;

import com.example.common.enums.BusinessType;
import com.example.common.enums.OperatorType;

import java.lang.annotation.*;


/**
 * @Classname RepeatSubmit
 * @Description 自定义操作日志记录注解
 * @Author hyd
 * @Date 2020/8/11 下午15:30
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
