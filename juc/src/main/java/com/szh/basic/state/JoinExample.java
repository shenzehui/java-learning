package com.szh.basic.state;

/**
 * Created by szh on 2023-05-10
 *
 * @author szh
 */

public class JoinExample {
    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {

        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    // 会先等待 A 执行完毕，在执行 B
    public static void main(String[] args) {
        JoinExample example = new JoinExample();
        example.test();
    }
}
