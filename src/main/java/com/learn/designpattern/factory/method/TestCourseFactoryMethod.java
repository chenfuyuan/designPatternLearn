package com.learn.designpattern.factory.method;

import com.learn.designpattern.factory.ICourse;

/**
 * @Description: 测试工厂方法模式
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:05
 */
public class TestCourseFactoryMethod {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse pythonCourse = factory.create();
        pythonCourse.record();

        factory = new JavaCourseFactory();
        ICourse javaCourse = factory.create();
        javaCourse.record();
    }
}
