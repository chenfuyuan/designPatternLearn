package com.learn.designpattern.proxy.service;

import com.learn.designpattern.proxy.bean.Order;

/**
 * @Description:
 * @Author: chenfuyuan
 * @Date: 2021/6/23 19:51
 */
public interface OrderService {
    int createOrder(Order order);
}
