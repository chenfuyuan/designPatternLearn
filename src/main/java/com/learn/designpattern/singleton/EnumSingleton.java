package com.learn.designpattern.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Description: 枚举实现单例模式
 * @Author: chenfuyuan
 * @Date: 2021/4/23 23:48
 */
public enum EnumSingleton {
    /**
     * 实例
     */
    INSTANCE;

    /**
     * 属性
     */
    private Object field;

    /**
     * 获取属性
     * @return 属性
     */
    public Object getField() {
        return field;
    }

    /**
     * 设置属性
     * @param field 属性
     */
    public void setField(Object field) {
        this.field = field;
    }

    /**
     * 获取单例
     * @return 单例
     */
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) throws Exception {
        EnumSingleton instance_1 = null;
        EnumSingleton instance_2 = EnumSingleton.getInstance();
        instance_2.setField(new Object());
        File file;
        FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance_2);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("EnumSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        instance_1 = (EnumSingleton) ois.readObject();
        ois.close();

        System.out.println(instance_1.getField());
        System.out.println(instance_2.getField());
        System.out.println(instance_1.getField() == instance_2.getField());
    }

}
