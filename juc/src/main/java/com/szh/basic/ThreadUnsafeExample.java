package com.szh.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by szh on 2023-05-10
 *
 * @author szh
 */

public class ThreadUnsafeExample {

    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        // 设置计数器的初始值 count = 10000
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            // 多个线程对同一个变量访问，操作的结果是不一致的
            executorService.execute(() -> {
                example.add();
                // 每调用一次计数器值 -1，直到 count 被减为 0，代表所有线程全部执行完毕。
                countDownLatch.countDown();
            });
        }
        // 等待计数器变为0，即等待所有异步线程执行完毕。
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
