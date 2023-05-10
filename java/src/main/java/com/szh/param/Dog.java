package com.szh.param;

/**
 * Created by szh on 2023-05-06
 *
 * @author szh
 */

public class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getObjectAddress() {
        return super.toString();
    }
}