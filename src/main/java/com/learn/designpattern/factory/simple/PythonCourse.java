package com.learn.designpattern.factory.simple;

/**
 * @Description: Python课程
 * @Author: chenfuyuan
 * @Date: 2021/4/20 19:37
 */
public class PythonCourse implements ICourse{
    @Override
    public void record() {
        System.out.println("录制Python课程");
    }
}
