package com.learn.designpattern.proxy.bean;

import lombok.Data;

/**
 * @Description: 订单类
 * @Author: chenfuyuan
 * @Date: 2021/6/23 19:49
 */
@Data
public class Order {
    private String orderInfo;

    private Long createTime;

    private String id;
}
