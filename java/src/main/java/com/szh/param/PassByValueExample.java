package com.szh.param;

/**
 * Created by szh on 2023-05-06
 *
 * @author szh
 */

public class PassByValueExample {
//    public static void main(String[] args) {
//        Dog dog = new Dog("A");
//        System.out.println(dog.getObjectAddress()); // com.szh.param.Dog@1b6d3586
//        func(dog);
//        System.out.println(dog.getObjectAddress()); // com.szh.param.Dog@1b6d3586
//        System.out.println(dog.getName()); // A
//    }
//
//    public static void func(Dog dog) {
//        System.out.println(dog.getObjectAddress()); // com.szh.param.Dog@1b6d3586
//        dog = new Dog("B");
//        System.out.println(dog.getObjectAddress()); // com.szh.param.Dog@4554617c
//        System.out.println(dog.getName()); // B
//    }

    public static void main(String[] args) {
        Dog dog = new Dog("A");
        func(dog);
        System.out.println(dog.getName());  // B
    }

    private static void func(Dog dog) {
        dog.setName("B");
    }
}
