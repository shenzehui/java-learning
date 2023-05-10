package com.szh.annoation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author szh
 * @Override：表示当前的方法定义将覆盖父类中的方法
 * @Deprecated：表示代码被弃用，如果使用了被@Deprecated注解的代码则编译器将发出警告
 * @SuppressWarnings：表示关闭编译器警告信息 <p>
 * Created by szh on 2023-05-08
 */

public class B extends A {

    /**
     * 重写父类的 test 方法
     */
    @Override
    public void test() {
        super.test();
    }

    /**
     * 被抛弃的方法
     */
    @Deprecated
    public void oldMethod() {
    }

    /**
     * 忽略告警
     * <p>
     * rawtypes: 使用generics时忽略没有指定相应的类型
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List processList() {
        ArrayList list = new ArrayList();
        return list;
    }
}
