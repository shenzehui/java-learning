package com.szh.lock;

/**
 * 可重入锁实例
 * synchronized 和 ReentrantLock 都是可重入锁
 * 指在同一个线程在外层方法获取锁的时候，再进入该线程的内层方法会自动获取锁（前提锁对象得是同一个对象或者class），不会因为之前已经获取过还没释放而阻塞。
 * Created by szh on 2023-05-10
 *
 * @author szh
 */

public class Widget {

    /**
     * 类中的两个方法都被 synchronized 修饰，doSomething() 调用 doOthers() 方法，因为 synchronized 是可重入的，
     * 所以同一个线程在调用doOthers()时可以直接获得当前对象的锁，进入doOthers()进行操作。
     * <p>
     * 如果是一个不可重入锁，那么当前线程在调用doOthers()之前需要将执行doSomething()时获取当前对象的锁释放掉，
     * 实际上该对象锁已被当前线程所持有，且无法释放。所以此时会出现死锁。
     */
    public synchronized void doSomething() {
        System.out.println("方法一执行...");
        doOthers();
    }

    public synchronized void doOthers() {
        System.out.println("方法2执行...");
    }

}
