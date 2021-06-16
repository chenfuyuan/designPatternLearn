package com.learn.designpattern.prototype;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * @Description: 测试原型模式
 * @Author: chenfuyuan
 * @Date: 2021/6/16 23:23
 */
public class PrototypeBeanTest {


    private PrototypeBean initBean() {
        PrototypeBean result = new PrototypeBean();
        result.setIntVariable(1);
        result.setStringVariable("001");
        result.setListVariable(new ArrayList());
        result.getListVariable().add("001");
        result.getListVariable().add("002");
        return result;
    }


    /**
     * 测试浅克隆，对引用类型变量改变
     */
    @Test
    public void demon01() {
        //新建原型对象
        PrototypeBean instance_01 = initBean();
        System.out.println("原型对象:"+instance_01);

        //克隆对象
        PrototypeBean instance_02 = (PrototypeBean) instance_01.clone();
        System.out.println("克隆对象:"+instance_02);

        //测试改变克隆对象是否影响原型对象
        instance_02.setIntVariable(2);
        instance_02.setStringVariable("002");
        instance_02.getListVariable().add("003");

        System.out.println("改变属性后的结果================");
        System.out.println("原型对象:"+instance_01);
        System.out.println("克隆对象:"+instance_02);
        System.out.println("listVariable是否是同一个对象" + (instance_01.getListVariable() == instance_02.getListVariable()));
        //当克隆为浅克隆时，引用类型变量，地址相同，为同一个对象。所以在克隆对象中对其进行改变，会影响到原对象

        //判断克隆对象是否相等
        System.out.println("两者是否相等:"+(instance_01==instance_02));
    }

    @Test
    public void demo02() {
        //新建原型对象
        PrototypeBean instance_01 = initBean();
        System.out.println("原型对象:"+instance_01);

        //克隆对象
        PrototypeBean instance_02 = (PrototypeBean) instance_01.deepClone();
        System.out.println("克隆对象:"+instance_02);

        //测试改变克隆对象是否影响原型对象
        instance_02.setIntVariable(2);
        instance_02.setStringVariable("002");
        instance_02.getListVariable().add("003");

        System.out.println("改变属性后的结果================");
        System.out.println("原型对象:"+instance_01);
        System.out.println("克隆对象:"+instance_02);
        System.out.println("listVariable是否是同一个对象" + (instance_01.getListVariable() == instance_02.getListVariable()));
        //使用深拷贝后，引用对象也被进行拷贝，所以呈现的结果为，不同对象

        //判断克隆对象是否相等
        System.out.println("两者是否相等:"+(instance_01==instance_02));
    }
}