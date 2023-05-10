package com.szh.reflect;

import java.lang.reflect.Field;

interface I1 {
}

interface I2 {
}

class Cell {
    public int mCellPublic;
}

class Animal extends Cell {
    private int mAnimalPrivate;
    protected int mAnimalProtected;
    int mAnimalDefault;
    public int mAnimalPublic;
    private static int sAnimalPrivate;
    protected static int sAnimalProtected;
    static int sAnimalDefault;
    public static int sAnimalPublic;
}

class Dog extends Animal implements I1, I2 {
    private int mDogPrivate;
    public int mDogPublic;
    protected int mDogProtected;
    private int mDogDefault;
    private static int sDogPrivate;
    protected static int sDogProtected;
    static int sDogDefault;
    public static int sDogPublic;
}

public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<Dog> dog = Dog.class;
        // 类名打印
        System.out.println(dog.getName()); //com.cry.Dog
        System.out.println(dog.getSimpleName()); //Dog
        System.out.println(dog.getCanonicalName());//com.cry.Dog
        // 接口
        System.out.println(dog.isInterface()); //false
        for (Class iI : dog.getInterfaces()) {
            System.out.println(iI);
        }
         /*
          interface com.cry.I1
          interface com.cry.I2
         */

        // 父类
        System.out.println(dog.getSuperclass());//class com.cry.Animal
        // 创建对象
        Dog d = dog.newInstance();
        // 字段
        for (Field f : dog.getFields()) {
            // 获得某个类的所有的公共（public）的字段，包括继承自父类的所有公共字段。
            System.out.println(f.getName());
        }
        /*
            mDogPublic
            sDogPublic
            mAnimalPublic
            sAnimalPublic
            mCellPublic  //父类的父类的公共字段也打印出来了
         */
        System.out.println("---------");
        for (Field f : dog.getDeclaredFields()) {
            System.out.println(f.getName());
        }
        /*  只有自己类声明的字段
             mDogPrivate
             mDogPublic
             mDogProtected
             mDogDefault
             sDogPrivate
             sDogProtected
             sDogDefault
             sDogPublic
         */
        System.out.println("---------------分割线--------------------");
        // 普通类
        System.out.println(Test.class.getSimpleName());
        System.out.println(Test.class.getName());
        System.out.println(Test.class.getCanonicalName());

        // 内部类
        System.out.println(inner.class.getSimpleName());
        System.out.println(inner.class.getName());
        System.out.println(inner.class.getSimpleName());

        // 数组
        System.out.println(args.getClass().getSimpleName());
        System.out.println(args.getClass().getName());
        System.out.println(args.getClass().getSimpleName());

        //我们不能用getCanonicalName去加载类对象，必须用getName
        //Class.forName(inner.class.getCanonicalName()); 报错
        Class<?> clazz = Class.forName(inner.class.getName());
    }

    private class inner {
    }

}