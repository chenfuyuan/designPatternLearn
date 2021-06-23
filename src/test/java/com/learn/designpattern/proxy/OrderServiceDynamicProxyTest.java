package com.learn.designpattern.proxy;

import com.learn.designpattern.proxy.bean.Order;
import com.learn.designpattern.proxy.service.OrderService;
import com.learn.designpattern.proxy.service.impl.OrderServiceDynamicProxy;
import com.learn.designpattern.proxy.service.impl.OrderServiceImpl;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: chenfuyuan
 * @Date: 2021/6/23 20:09
 */
public class OrderServiceDynamicProxyTest {
    @Test
    public void demo01() {
        Order order = new Order();
        order.setCreateTime(System.currentTimeMillis());

        OrderService orderService = (OrderService) new OrderServiceDynamicProxy().getInstace(new OrderServiceImpl());
        orderService.createOrder(order);
    }

    /**
     * 生成代理类的.class文件
     */
    @Test
    public void demo02() throws IOException {
        OrderService proxyClass = (OrderService) new OrderServiceDynamicProxy().getInstace(new OrderServiceImpl());
        OrderService origenClass = new OrderServiceImpl();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{OrderService.class});
        FileOutputStream os= new FileOutputStream("E://proxySource/$Proxy0.class");
        os.write(bytes);
        os.close();

    }
}
