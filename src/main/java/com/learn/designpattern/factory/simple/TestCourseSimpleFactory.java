package com.learn.designpattern.factory.simple;

import com.learn.designpattern.factory.ICourse;
import com.learn.designpattern.factory.JavaCourse;

/**
 * @Description: 测试课程工厂
 * @Author: chenfuyuan
 * @Date: 2021/4/20 19:40
 */
public class TestCourseSimpleFactory {

    public static void main(String[] args) {
        ICourse course = CourseSimpleFactory.getCourse(JavaCourse.class);
        course.record();
    }
}
