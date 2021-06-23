package com.learn.designpattern.proxy.dao;

import com.learn.designpattern.proxy.bean.Order;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: chenfuyuan
 * @Date: 2021/6/23 19:50
 */
public class OrderDao {
    public int insert(Order order) {
        System.out.println("OrderDao创建Order成功");
        return 1;
    }
}
