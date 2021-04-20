package com.learn.designpattern.factory.method;

import com.learn.designpattern.factory.ICourse;
import com.learn.designpattern.factory.JavaCourse;

/**
 * @Description: java课程工厂
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:03
 */
public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        //.....具体的创建过程
        return new JavaCourse();
    }
}
