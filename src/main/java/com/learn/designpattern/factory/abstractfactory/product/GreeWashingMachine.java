package com.learn.designpattern.factory.abstractfactory.product;

/**
 * @Description: 格力洗衣机
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:30
 */
public class GreeWashingMachine implements IWashingMachine {
    @Override
    public void startUp() {
        System.out.println("格力洗衣机启动");
    }
}
