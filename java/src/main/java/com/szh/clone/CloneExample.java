package com.szh.clone;

/**
 * Created by szh on 2023-05-06
 *
 * @author szh
 */

public class CloneExample implements Cloneable {
    private int a;
    private int b;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
//        try {
//            CloneExample example = new CloneExample();
//            example.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        ShallowCloneExample e1 = new ShallowCloneExample();
//        ShallowCloneExample e2 = null;
//        try {
//            e2 = e1.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(e2.get(2));
//        e1.set(2, 222);
//        System.out.println(e2.get(2));

//        DeepCloneExample e1 = new DeepCloneExample();
//        DeepCloneExample e2 = null;
//        try {
//            e2 = e1.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        e1.set(2, 222);
//        System.out.println(e2.get(2)); // 2

        CloneConstructorExample e1 = new CloneConstructorExample();
        CloneConstructorExample e2 = new CloneConstructorExample(e1);
        e1.set(2, 222);
        System.out.println(e1.get(2)); // 222
        System.out.println(e2.get(2)); // 2
    }
}
