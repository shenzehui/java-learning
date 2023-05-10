package com.szh.basic;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by szh on 2023-05-10
 *
 * @author szh
 */

public class VectorSafeExample {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 100; i++) {
                vector.add(i);
            }
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(() -> {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println("删除" + i);
                        vector.remove(i);
                    }
                }
            });
            executorService.execute(() -> {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println("删除" + i);
                        vector.remove(i);
                    }
                }
            });
            executorService.shutdown();
        }
    }
}
