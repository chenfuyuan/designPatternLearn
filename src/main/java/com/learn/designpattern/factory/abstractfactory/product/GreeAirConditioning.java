package com.learn.designpattern.factory.abstractfactory.product;

/**
 * @Description: 格力空调
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:30
 */
public class GreeAirConditioning implements IAirConditioning {
    @Override
    public void startUp() {
        System.out.println("格力空调启动");
    }
}
