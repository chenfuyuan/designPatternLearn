package com.learn.designpattern.proxy.service.impl;

import com.learn.designpattern.proxy.bean.DynamicDataSourceEntry;
import com.learn.designpattern.proxy.bean.Order;
import com.learn.designpattern.proxy.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: chenfuyuan
 * @Date: 2021/6/23 19:56
 */
public class OrderServiceStaticProxy implements OrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private OrderService orderService;


    public OrderServiceStaticProxy(OrderService orderService) {
        this.orderService = orderService;
    }



    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void after() {
        System.out.println("Proxy after method.");
    }

    private void before() {
        System.out.println("Proxy before method.");
    }
}
