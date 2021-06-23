package com.learn.designpattern.proxy.service.impl;

import com.learn.designpattern.proxy.bean.Order;
import com.learn.designpattern.proxy.dao.OrderDao;
import com.learn.designpattern.proxy.service.OrderService;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: chenfuyuan
 * @Date: 2021/6/23 20:13
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl() {
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderServiceImpl调用orderDao创建订单");
        orderDao.insert(order);
        return 1;
    }

    @Override
    public void test() {

    }
}
