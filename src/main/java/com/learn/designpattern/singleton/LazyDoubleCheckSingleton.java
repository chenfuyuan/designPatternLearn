package com.learn.designpattern.singleton;

/**
 * @Description: 双重检查锁实现单例模式
 * @Author: chenfuyuan
 * @Date: 2021/4/23 23:16
 */
public class LazyDoubleCheckSingleton {

    /**
     * 实例
     */
    private static LazyDoubleCheckSingleton INSTANCE;

    private LazyDoubleCheckSingleton() {

    }

    /**
     * 获取实例
     * @return 单例实例
     */
    public static LazyDoubleCheckSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (null == INSTANCE) {
                    INSTANCE = new LazyDoubleCheckSingleton();
                }
            }
        }

        return INSTANCE;
    }


    public static void main(String[] args) {
        /*
        LazyDoubleCheckSingleton instance_1 = LazyDoubleCheckSingleton.getInstance();
        LazyDoubleCheckSingleton instance_2 = LazyDoubleCheckSingleton.getInstance();
        System.out.println(instance_1);
        System.out.println(instance_2);
         */

        //测试是否线程安全
        Thread thread_1 = new Thread(new TestThread());
        Thread thread_2 = new Thread(new TestThread());
        thread_1.start();
        thread_2.start();
    }

    private static class TestThread implements Runnable{


        @Override
        public void run() {
            LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
            System.out.println(instance);
        }
    }
}
