package com.learn.designpattern.factory;

/**
 * @Description: Java课程
 * @Author: chenfuyuan
 * @Date: 2021/4/20 19:36
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}
