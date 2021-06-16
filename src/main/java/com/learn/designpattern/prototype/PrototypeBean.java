package com.learn.designpattern.prototype;

import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 原型模式Bean
 * @Author: chenfuyuan
 * @Date: 2021/6/16 23:10
 */
@Data
public class PrototypeBean implements Cloneable, Serializable {

    private int intVariable;

    private String stringVariable;

    private List<String> listVariable;

    @Override
    public PrototypeBean clone() {
        try {
            return  (PrototypeBean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 深克隆
     * 序列化方式
     * @return 深克隆对象
     */
    public PrototypeBean deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (PrototypeBean) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeBean instance_01 = new PrototypeBean();
        Object clone = instance_01.clone();
    }


}
