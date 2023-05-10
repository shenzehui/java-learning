package com.szh.basic;

/**
 * Created by szh on 2023-05-10
 *
 * @author szh
 */

public class DaemonExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
    }
}
