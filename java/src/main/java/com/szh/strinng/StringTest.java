package com.szh.strinng;

/**
 * Created by szh on 2023-05-06
 *
 * @author szh
 */

public class StringTest {

    public static void main(String[] args) {
        // s1，s2 采用 new String() 方式新建了两个不同的对象
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2); // false
        // 获取 s1 对象的引用，并赋值给 s3
        String s3 = s1.intern();
        System.out.println(s1.intern() == s3); // true
    }

}
