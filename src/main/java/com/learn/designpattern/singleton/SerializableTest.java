package com.learn.designpattern.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Description: 反序列化破坏单例模式
 * @Author: chenfuyuan
 * @Date: 2021/6/14 9:09
 */
public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String objFileName = "SeriableSingleLeton.obj";
        LazySimpleSingleton instance_01 = LazySimpleSingleton.getInstance();
        //写入实例
        FileOutputStream fos =new FileOutputStream(objFileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance_01);
        oos.flush();
        oos.close();

        //读取实例
        FileInputStream fis = new FileInputStream(objFileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        LazySimpleSingleton instance_02 = (LazySimpleSingleton) ois.readObject();
        ois.close();

        System.out.println(instance_01);
        System.out.println(instance_02);
        System.out.println(instance_01==instance_02);

    }
}
