package com.example.common.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: RepeatSubmit
 * @Description: 自定义注解防止表单重复提交
 * @Author hzy
 * @Date 2020/8/11 14:59
 **/
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {
}
