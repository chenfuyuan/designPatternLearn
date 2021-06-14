package com.learn.designpattern.singleton;

/**
 * @Description: 线程单例
 * 保证实例，线程内单例
 * @Author: chenfuyuan
 * @Date: 2021/6/14 9:45
 */
public class ThreadLocalSingleton {
    private ThreadLocalSingleton() {

    }

    private static ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstace() {
        return threadLocalInstance.get();
    }

    public static void main(String[] args) {
        System.out.println("测试线程是否为单例");
        System.out.println(ThreadLocalSingleton.getInstace());
        System.out.println(ThreadLocalSingleton.getInstace());
        System.out.println(ThreadLocalSingleton.getInstace());
        System.out.println(ThreadLocalSingleton.getInstace());

        Runnable runnable = ()->{
            System.out.println(Thread.currentThread().getName()+ThreadLocalSingleton.getInstace());
        };
        Thread thread_01 = new Thread(runnable);
        thread_01.start();
        Thread thread_02 = new Thread(runnable);
        thread_02.start();
    }
}
