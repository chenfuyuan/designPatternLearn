package com.learn.designpattern.factory.method;

import com.learn.designpattern.factory.ICourse;

/**
 * @Description: 抽象工厂类
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:02
 */
public interface ICourseFactory {

    /**
     * 创建产品
     * @return 产品
     */
    ICourse create();
}
