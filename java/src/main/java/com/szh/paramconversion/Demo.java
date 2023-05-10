package com.szh.paramconversion;

/**
 * Created by szh on 2023-05-06
 * 隐式类型转换
 *
 * @author szh
 */

public class Demo {
    public static void main(String[] args) {
        short s = 1;
        // int 精度要高于 short，所以存在向下转型，导致精度丢失
//        s = s + 1;
        // 隐式类型转换
        s += 1;

        // 与 s += 1 一样
        s = (short) (s + 1);
    }
}
