package com.szh.switchdemo;

/**
 * Created by szh on 2023-05-06
 *
 * @author szh
 */

public class Demo {
    public static void main(String[] args) {
        String s = "a";
        switch (s) {
            case "a":
                System.out.println("aaa");
                break;
            case "b":
                System.out.println("bbb");
                break;
        }

//        long x = 111;
//        switch (x) { // Incompatible types. Found: 'long', required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'
//            case 111:
//                System.out.println(111);
//                break;
//            case 222:
//                System.out.println(222);
//                break;
//        }
    }
}
