package com.learn.designpattern.singleton;

/**
 * @Description: 饿汉式单例模式
 * @Author: chenfuyuan
 * @Date: 2021/4/23 22:40
 */
public class HungryStaticSingleton {


    /**
     * 实例常量
     */
    private static final HungryStaticSingleton INSTANCE;

    //实例初始化
    static {
        INSTANCE = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){

    }

    /**
     * 返回单例对象
     * @return 对象
     */
    public static HungryStaticSingleton getInstance() {
        return INSTANCE;
    }
}
