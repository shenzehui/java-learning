package com.szh.basic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by szh on 2023-05-10
 *
 * @author szh
 */

public class ImmutableExample {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        // 使用 Collections.unmodifiableXXX() 方法来获取一个不可变的集合
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("a", 1);
    }
}
