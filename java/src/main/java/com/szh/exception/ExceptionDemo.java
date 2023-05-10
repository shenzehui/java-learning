package com.szh.exception;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by szh on 2023-05-08
 * <p>
 * throws 声明异常
 * throw  抛出异常
 *
 * @author szh
 */

public class ExceptionDemo {

    public static void readFile(String filePath) throws MyException {
        File file = new File(filePath);
        String result;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((result = reader.readLine()) != null) {
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            System.out.println("readFile method catch block.");
            MyException ex = new MyException("read file failed.");
            ex.initCause(e);
            throw ex;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("readline method finally block.");
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //以Lock加锁为例，演示try-finally
        ReentrantLock lock = new ReentrantLock();
        try {
            //需要加锁的代码
        } finally {
            lock.unlock(); //保证锁一定被释放
        }
    }

    // java 7 try-with-resource  前提：try 中资源类需要实现 Closeable 接口
    private static void tryWithResourceTest() {
        // try 代码块退出时，会自动调用 scanner.close 方法
        try (Scanner scanner = new Scanner(new FileInputStream("c:/abc"), "UTF-8")) {
            // code
        } catch (IOException e) {
            // handle exception
        }
    }

}
