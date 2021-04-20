package com.learn.designpattern.factory.abstractfactory;

import com.learn.designpattern.factory.abstractfactory.product.GreeAirConditioning;
import com.learn.designpattern.factory.abstractfactory.product.GreeWashingMachine;
import com.learn.designpattern.factory.abstractfactory.product.IAirConditioning;
import com.learn.designpattern.factory.abstractfactory.product.IWashingMachine;

/**
 * @Description: 格力电器工厂
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:32
 */
public class GreeElectricalFactory extends AbstractElectricalFactory {
    @Override
    protected IAirConditioning createAirConditioning() {
        return new GreeAirConditioning();
    }

    @Override
    protected IWashingMachine createWashingMachine() {
        return new GreeWashingMachine();
    }
}
