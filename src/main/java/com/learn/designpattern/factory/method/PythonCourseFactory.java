package com.learn.designpattern.factory.method;

import com.learn.designpattern.factory.ICourse;
import com.learn.designpattern.factory.PythonCourse;

/**
 * @Description: Python课程工厂类
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:04
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        //....具体的创建过程
        return new PythonCourse();
    }
}
