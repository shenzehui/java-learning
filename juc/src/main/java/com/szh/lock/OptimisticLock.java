package com.szh.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 乐观锁认为自己在使用数据时不会有别的线程修改数据，所以不会添加锁，只是在更新数据的时候去判断之前有没有别的线程更新了这个数据
 * 乐观锁：适合读操作多的场景，不加锁的特点能够使其读操作的性能大幅提升。
 * Created by szh on 2023-05-10
 *
 * @author szh
 */

public class OptimisticLock {

    private static AtomicInteger atomicInteger = new AtomicInteger();  // 需要保证多个线程使用的是同一个AtomicInteger

    public static void main(String[] args) {
        atomicInteger.incrementAndGet();  // 执行自增1
    }


}
