package com.szh.exception;

/**
 * Created by szh on 2023-05-08
 *
 * @author szh
 */

public class ExceptionDemo2 {
    public static void simpleTryCatch() {
        try {
            testNPE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testNPE() {
        throw new NullPointerException();
    }

    public static void main(String[] args) {
        ExceptionDemo2.simpleTryCatch();
    }
}
