package com.szh.basic.state;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by szh on 2023-05-10
 * <p>
 * wait() 和 sleep() 的区别：
 * wait() 是 Object 的方法，而 sleep() 是 Thread 的静态方法；
 * wait() 会释放锁，sleep() 不会
 *
 * @author szh
 */

public class WaitNotifyExample {
    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after() {
        try {
            // wait() 是 Object 的方法
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> waitNotifyExample.after());
        executorService.execute(() -> waitNotifyExample.before());
    }
}
