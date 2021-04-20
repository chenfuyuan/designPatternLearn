package com.learn.designpattern.factory.simple;

import java.util.Calendar;

/**
 * @Description: 测试课程工厂
 * @Author: chenfuyuan
 * @Date: 2021/4/20 19:40
 */
public class TestCourseFactory {

    public static void main(String[] args) {
        ICourse course = CourseFactory.getCourse(JavaCourse.class);
        course.record();

        Calendar calendar = Calendar.getInstance();

    }
}
