package com.szh.basic.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by szh on 2023-05-10
 * <p>
 * synchronized 是 JVM 实现
 * 总结：
 * this：同步一个代码块，作用于一个对象
 * 类.class：同步一个类，作用于整个类
 *
 * @author szh
 */

public class SynchronizedExample {

    // 同步一个代码块，它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
        }
    }

    // 它和同步代码块一样，作用于同一个对象。
    public synchronized void func2() {
        // ...
    }

    // 同步一个类，作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
    public void func3() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
        }
    }

    // 同步一个静态方法，作用于整个类
    public synchronized static void fun4() {
        // ...
    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();

        /*------------------------- synchronized (this)的使用--------------------------*/
        // 作用两个不同的对象，不会进行同步
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e2.func1());

        // 作用同一个对象，同步
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());

        /*------------------------- synchronized (类.class)的使用--------------------------*/

        // 作用同一个对象，同步
        executorService.execute(() -> e1.func3());
        executorService.execute(() -> e1.func3());

        // 作用不同对象，也同步
//        executorService.execute(() -> e1.func3());
//        executorService.execute(() -> e2.func3());

        executorService.shutdown();
    }
}
