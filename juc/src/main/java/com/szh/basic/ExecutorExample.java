package com.szh.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by szh on 2023-05-10
 * <p>
 * 主要有三种
 * Executor:CachedThreadPool: 一个任务创建一个线程；
 * FixedThreadPool: 所有任务只能使用固定大小的线程；
 * SingleThreadExecutor: 相当于大小为 1 的 FixedThreadPool。
 *
 * @author szh
 */

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        // 调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭
        executorService.shutdown();

        // 如果只想中断 Executor 中的一个线程，可以通过使用 submit() 方法来提交一个线程，它会返回一个 Future<?> 对象，通过调用该对象的 cancel(true) 方法就可以中断线程。
        Future<?> future = executorService.submit(() -> {
            //...
        });
        future.cancel(true);
    }
}
