package com.learn.designpattern.singleton;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 容器式单例模式
 * @Author: chenfuyuan
 * @Date: 2021/6/14 9:29
 */
public class ContainerSingleton {
    /**
     * 私有化构造器
     */
    private ContainerSingleton() {

    }

    /**
     * Bean容器
     */
    private static Map<String, Object> container = new HashMap();


    /**
     * 获取实例
     * @param className 类名
     * @return
     */
    public static Object getBean(String className) {
        //判断Bean容器中，是否存在实例
        if (!container.containsKey(className)) {
            //双重检测锁
            synchronized (container) {
                if (!container.containsKey(className)) {
                    Object obj = null;
                    try {
                        obj = Class.forName(className).newInstance();
                        container.put(className, obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return obj;
                }
            }
        }
        //容器中已经存在实例，直接获取
        return container.get(className);
    }

    public static void main(String[] args) {
        ContainerSingleton instance_01 = (ContainerSingleton) ContainerSingleton.getBean(ContainerSingleton.class.getName());
        ContainerSingleton instance_02 = (ContainerSingleton) ContainerSingleton.getBean(ContainerSingleton.class.getName());
        System.out.println(instance_01);
        System.out.println(instance_02);
        System.out.println(instance_01 == instance_02);
    }
}
