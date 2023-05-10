package com.szh.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 悲观锁认为自己在使用数据的时候一定有别的线程来修改数据，因此在获取数据的时候会先加锁，确保数据不会被别的线程修改。
 * 悲观锁：适合写操作多的场景，先加锁可以保证写操作时数据正确。
 * Created by szh on 2023-05-10
 *
 * @author szh
 */

public class PessimisticLock {
    /*--------------------悲观锁的调用方式------------------*/

    // synchronized
    public synchronized void testMethod() {
        // 操作同步资源
    }

    //ReentrantLock
    private ReentrantLock lock = new ReentrantLock(); // 需要保证多个线程使用的是同一个锁

    public void modifyPublicResources() {
        lock.lock();
        // 操作同步资源
        lock.unlock();
    }

}
