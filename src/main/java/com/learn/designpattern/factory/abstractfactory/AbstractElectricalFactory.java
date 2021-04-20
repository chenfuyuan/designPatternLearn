package com.learn.designpattern.factory.abstractfactory;

import com.learn.designpattern.factory.abstractfactory.product.IAirConditioning;
import com.learn.designpattern.factory.abstractfactory.product.IWashingMachine;

/**
 * @Description: 抽象工厂(电器工厂)
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:22
 */
public abstract class AbstractElectricalFactory {

    public void init() {
        System.out.println("初始化工厂");
    }

    /**
     * 创建空调
     * @return 空调实例
     */
    protected abstract IAirConditioning createAirConditioning();

    /**
     * 创建洗衣机
     * @return 洗衣机实例
     */
    protected abstract IWashingMachine createWashingMachine();
}
