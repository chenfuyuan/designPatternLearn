package com.learn.designpattern.factory.abstractfactory.product;

/**
 * @Description: 美的空调
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:28
 */
public class MediaAirConditioning implements IAirConditioning{


    @Override
    public void startUp() {
        System.out.println("美的空调开机");
    }
}
