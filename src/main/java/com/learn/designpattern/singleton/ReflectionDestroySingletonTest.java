package com.learn.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description: 反射破坏静态内部类
 * @Author: chenfuyuan
 * @Date: 2021/4/23 23:35
 */
public class ReflectionDestroySingletonTest {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = LazyStaticInnerClassSingleton.class;

        //反射获取私有构造器
        Constructor constructor = clazz.getDeclaredConstructor(null);
        //强制访问
        constructor.setAccessible(true);

        //调用方法创建对象
        Object o2 = LazyStaticInnerClassSingleton.getInstance();
        //反射创建对象
        Object o1 = constructor.newInstance();

        System.out.println(o1);
        System.out.println(o2);
    }
}
