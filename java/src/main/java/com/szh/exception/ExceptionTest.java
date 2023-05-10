package com.szh.exception;

/**
 * Created by szh on 2023-05-08
 * 检验异常耗时情况
 * <p>
 * 建立对象：575817
 * 建立异常对象：9589080
 * 建立、抛出并接住异常对象：47394475
 *
 * @author szh
 */

public class ExceptionTest {
    private int testTime;

    public ExceptionTest(int testTime) {
        this.testTime = testTime;
    }

    public void newObject() {
        long l = System.nanoTime();
        for (int i = 0; i < testTime; i++) {
            new Object();
        }
        System.out.println("建立对象:" + (System.nanoTime() - l));
    }

    public void newException() {
        long l = System.nanoTime();
        for (int i = 0; i < testTime; i++) {
            new Exception();
        }
        System.out.println("建立异常对象" + (System.nanoTime() - l));
    }

    public void catchException() {
        long l = System.nanoTime();
        for (int i = 0; i < testTime; i++) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("建立、抛出并接住异常对象：" + (System.nanoTime() - l));
    }

    public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest(10000);
        test.newObject();
        test.newException();
        test.catchException();
    }
}
