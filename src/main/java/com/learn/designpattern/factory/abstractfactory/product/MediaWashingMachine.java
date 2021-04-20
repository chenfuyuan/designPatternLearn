package com.learn.designpattern.factory.abstractfactory.product;

/**
 * @Description: 美的洗衣机
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:29
 */
public class MediaWashingMachine implements IWashingMachine {
    @Override
    public void startUp() {
        System.out.println("美的洗衣机开机");
    }
}
