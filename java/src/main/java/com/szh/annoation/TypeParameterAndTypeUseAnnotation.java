package com.szh.annoation;

import java.util.ArrayList;

/**
 * Created by szh on 2023-05-08
 * <p>
 * Java8 新注解 ElementType.TYPE_USE
 *
 * @author szh
 */

public class TypeParameterAndTypeUseAnnotation<T> {

    // 使用TYPE_PARAMETER类型，会编译不通过
//    public @MyNotNull T test(@MyNotEmpty T a) {
//        new ArrayList<@MyNotEmpty String>();
//        return a;
//    }

    //使用TYPE_USE类型，编译通过
    public @MyNotNull T test2(@MyNotNull T a) {
        new ArrayList<@MyNotNull String>();
        return a;
    }
}
