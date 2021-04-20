package com.learn.designpattern.factory.abstractfactory.factory;

import com.learn.designpattern.factory.abstractfactory.product.IAirConditioning;
import com.learn.designpattern.factory.abstractfactory.product.IWashingMachine;
import com.learn.designpattern.factory.abstractfactory.product.MediaAirConditioning;
import com.learn.designpattern.factory.abstractfactory.product.MediaWashingMachine;

/**
 * @Description: 美的电器工厂
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:27
 */
public class MediaElectricalFactory extends AbstractElectricalFactory{

    @Override
    public IAirConditioning createAirConditioning() {
        return new MediaAirConditioning();
    }

    @Override
    public IWashingMachine createWashingMachine() {
        return new MediaWashingMachine();
    }
}
