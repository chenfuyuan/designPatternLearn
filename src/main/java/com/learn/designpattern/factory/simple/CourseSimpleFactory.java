package com.learn.designpattern.factory.simple;

import com.learn.designpattern.factory.ICourse;

/**
 * @Description: 课程工厂
 * @Author: chenfuyuan
 * @Date: 2021/4/20 19:38
 */
public class CourseSimpleFactory {

    /**
     * 获取课程
     * @param clazz 课程类
     * @return 对应的课程
     */
    public static ICourse getCourse(Class<? extends ICourse> clazz) {
        return getCourse(clazz.getName());
    }

    /**
     * 获取课程
     * @param className 课程类名
     * @return 对应的课程
     */
    public static ICourse getCourse(String className) {
        if (!(null == className || "".equals(className))) {
            try {
                return (ICourse)Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
