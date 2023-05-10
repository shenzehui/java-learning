package com.szh.synchronizedlock;

/**
 * Created by szh on 2023-05-10
 *
 * @author szh
 */

public class SynchronizedObjectLock implements Runnable {

    static SynchronizedObjectLock instance = new SynchronizedObjectLock();

    // 创建两把锁
    Object object1 = new Object();
    Object object2 = new Object();


    @Override
    public void run() {

        /*----------------------------------代码块形式-----------------------------------------*/
        // 同步代码块形式——锁this，两个线程使用的锁是一样的，线程1必须要等到线程0释放了该锁后，才能执行
//        synchronized (this) {
//            System.out.println("我是线程" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "结束");
//        }

        // 这个代码块使用的是第一把锁，当他释放后，后面的代码块由于使用的是第二把锁，因此可以马上执行
//        synchronized (object1) {
//            System.out.println("block1锁，我是线程：" + Thread.currentThread().getName());
//
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("block1锁：我是线程：" + Thread.currentThread().getName() + "结束");
//        }
//
//        synchronized (object2) {
//            System.out.println("block2锁，我是线程：" + Thread.currentThread().getName());
//
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("block2锁：我是线程：" + Thread.currentThread().getName() + "结束");
//        }

        /*----------------------------------方法锁形式-----------------------------------------*/
//        method();

        /*----------------------------------类锁-----------------------------------------*/
//        method();

//        method1();

        // 所有线程需要的锁都是同一把（作用于同一个类）
        synchronized (SynchronizedObjectLock.class) {
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    // synchronized 用在普通方法上， 默认的锁就是 this，当前实例(作用于同一个对象)
    public synchronized void method() {
        System.out.println("我是线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    // synchronized 用在静态方法上，默认的锁就是当前所在的Class类，所以无论是哪个线程访问它，需要的锁都只有一把（作用于同一个类）
    public static synchronized void method1() {
        System.out.println("我是线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }
}
