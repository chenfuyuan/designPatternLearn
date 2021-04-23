package com.learn.designpattern.factory.abstractfactory;

import com.learn.designpattern.factory.abstractfactory.factory.DbConnectionPool;
import com.learn.designpattern.factory.abstractfactory.factory.Pool;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.sql.Connection;
import java.util.Vector;

/**
 * @Description: 测试使用抽象工厂的连接工具类
 * @Author: chenfuyuan
 * @Date: 2021/4/20 23:45
 */
public class TestDbConnection {
    public static void main(String[] args) {
        Pool dbPool = DbConnectionPool.getInstance();
        Vector<Connection> connections = new Vector<>();
        for (int i = 0; i < 15; i++) {
            Connection connection = dbPool.getConnection();
            connections.addElement(connection);
        }

        connections.forEach(item->{
            dbPool.freeConnection(item);
        });
    }
}
