package com.learn.designpattern.proxy.service;

import com.learn.designpattern.proxy.bean.Order;

import java.io.Serializable;

/**
 * @Description:
 * @Author: chenfuyuan
 * @Date: 2021/6/23 19:51
 */
public interface OrderService extends Serializable {
    int createOrder(Order order);

    void test();
}
