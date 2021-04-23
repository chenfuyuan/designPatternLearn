package com.learn.designpattern.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 懒汉式
 * @Author: chenfuyuan
 * @Date: 2021/4/23 22:50
 */
public class LazySimpleSingleton {

    /**
     * 单例对象
     */
    private static LazySimpleSingleton INSTANCE;


    /**
     * 私有化构造函数
     */
    private LazySimpleSingleton() {

    }

    /**
     * 获取单例对象
     *
     * @return 单例对象
     */
    public static LazySimpleSingleton getInstance() {
        if (INSTANCE == null) {
            //在此加断点，进行模拟线程中断
            INSTANCE = new LazySimpleSingleton();
        }

        return INSTANCE;
    }


    public static void main(String[] args) {
        //测试是否单例
        /*LazySimpleSingleton instanceOne = LazySimpleSingleton.getInstance();
        LazySimpleSingleton instanceTwo = LazySimpleSingleton.getInstance();
        System.out.println(instanceOne);
        System.out.println(instanceTwo);*/

        //测试多线程导致不是单例
        Thread t1 = new Thread(new ExctorThread());
        Thread t2 = new Thread(new ExctorThread());
        t1.start();
        t2.start();



    }

    static class ExctorThread implements Runnable {

        @Override
        public void run() {
            LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+instance);
        }
    }

}
