package com.learn.designpattern.singleton;

/**
 * @Description: 静态内部类
 * @Author: chenfuyuan
 * @Date: 2021/4/23 23:28
 */
public class LazyStaticInnerClassSingleton {

    /**
     * 使用LazyStaticInnerClass类时，默认会先初始化内部类
     * 如果没使用，则内部类是不加载的
     */
    private LazyStaticInnerClassSingleton() {
        if (LazyHolder.INSTANCE != null) {
            throw new MoreInstanceException();
        }
    }

    public static LazyStaticInnerClassSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }



    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }

}

