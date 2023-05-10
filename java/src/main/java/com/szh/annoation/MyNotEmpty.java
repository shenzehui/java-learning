package com.szh.annoation;

/**
 * Created by szh on 2023-05-08
 *
 * @author szh
 */

// 自定义ElementType.TYPE_PARAMETER注解

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// 用于参数注解
@Target(ElementType.TYPE_PARAMETER)
public @interface MyNotEmpty {
}
