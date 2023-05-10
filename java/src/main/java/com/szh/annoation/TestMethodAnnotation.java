package com.szh.annoation;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by szh on 2023-05-08
 *
 * @author szh
 */

public class TestMethodAnnotation {

    @MyMethodAnnotation(title = "toStringMethod", description = "overwrite toString method")
    @Override
    public String toString() {
        return "Overwrite toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyMethodAnnotation(title = "test method", description = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }

    public static void main(String[] args) {
        try {
            // 获取所有 methods
            Method[] methods = TestMethodAnnotation.class.getClassLoader().loadClass("com.szh.annoation.TestMethodAnnotation").getMethods();
            for (Method method : methods) {
                // 方法上是否有 MyMethodAnnotation 注解
                if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                    try {
                        // 遍历方法上的所有注解
                        for (Annotation annotation : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "' : " + annotation);
                        }
                        // 获取 MyMethodAnnotation 对象信息
                        MyMethodAnnotation methodAnno = method.getAnnotation(MyMethodAnnotation.class);
                        System.out.println(methodAnno.title());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
