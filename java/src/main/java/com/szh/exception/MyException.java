package com.szh.exception;

/**
 * Created by szh on 2023-05-06
 *
 * @author szh
 */
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
    // ...
}