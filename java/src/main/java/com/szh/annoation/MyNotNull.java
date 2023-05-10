package com.szh.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by szh on 2023-05-08
 *
 * @author szh
 */

// 自定义ElementType.TYPE_USE注解
@Retention(RetentionPolicy.RUNTIME)
// type_use：包含 ElementType.TYPE 和 ElementType.TYPE_PARAMETER
@Target(ElementType.TYPE_USE)
public @interface MyNotNull {
}
