package com.szh.integer;

/**
 * Created by szh on 2023-05-06
 *
 * @author szh
 */

public class IntegerTest {

    /**
     * 装箱
     */
    Integer x = 2;
    /**
     * 拆箱
     */
    int y = x;

    public static void main(String[] args) {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        // false  每次创建都会新建一个对象
        System.out.println(x == y);

        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        // true 从缓存池中取数据
        System.out.println(z == k);


        // 在缓存池中的基本数据类型自动装箱会直接调用 valueOf() 方法，也就是直接从缓存池中取数据，那么就会引用相同的对象
        Integer m = 123;
        Integer n = 123;
        System.out.println(m == n); // true


        // 这里因为 323 超过了 127，所以超出缓冲区，所以不会从缓存池中取数据，而是 new Integer(323);
        Integer o = 323;
        Integer p = 323;
        System.out.println(o == p); // false
    }
}
