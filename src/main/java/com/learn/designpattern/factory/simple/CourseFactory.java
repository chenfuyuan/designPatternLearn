package com.learn.designpattern.factory.simple;

/**
 * @Description: 课程工厂
 * @Author: chenfuyuan
 * @Date: 2021/4/20 19:38
 */
public class CourseFactory {

    /**
     * 获取课程
     * @param clazz 课程类
     * @return 对应的课程
     */
    public static ICourse getCourse(Class<? extends ICourse> clazz) {
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
