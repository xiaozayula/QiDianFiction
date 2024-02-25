package com.xiaoyu.anno;

import com.xiaoyu.validation.StateValidation;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/25/19:35
 * @Description:
 */

@Documented//元注解
@Constraint(validatedBy = {StateValidation.class})//指定提供校验规则的类
@Target({ FIELD})//元注解
@Retention(RUNTIME)//元注解

public @interface State {
    //提供校验失败的提示信息
    String message() default "{jakarta.validation.constraints.NotEmpty.message}";
    //指定分组
   Class<?>[] groups() default {};
   //负载 获取State注解的附加信息
   Class<? extends jakarta.validation.Payload>[] payload() default {};

}
