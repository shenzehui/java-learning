package com.szh.basic.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by szh on 2023-05-10
 * ReentrantLock 是 JDK 实现的
 *
 * @author szh
 */

public class ReentrantLockExample {

    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample e = new ReentrantLockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e.func());
    }
}
