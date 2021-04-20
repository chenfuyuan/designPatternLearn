package com.learn.designpattern.factory.abstractfactory;

import com.learn.designpattern.factory.abstractfactory.factory.MediaElectricalFactory;

/**
 * @Description: 测试抽象工厂
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:33
 */
public class TestAbstractFactory {

    public static void main(String[] args) {
        MediaElectricalFactory factory = new MediaElectricalFactory();
        factory.createAirConditioning().startUp();
        factory.createWashingMachine().startUp();
    }
}
