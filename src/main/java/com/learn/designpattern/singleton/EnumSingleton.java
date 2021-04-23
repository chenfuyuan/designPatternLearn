package com.learn.designpattern.singleton;

/**
 * @Description: 枚举实现单例模式
 * @Author: chenfuyuan
 * @Date: 2021/4/23 23:48
 */
public enum EnumSingleton {
    /**
     * 实例
     */
    INSTANCE;

    /**
     * 属性
     */
    private Object field;

    /**
     * 获取属性
     * @return 属性
     */
    public Object getField() {
        return field;
    }

    /**
     * 设置属性
     * @param field 属性
     */
    public void setField(Object field) {
        this.field = field;
    }

    /**
     * 获取单例
     * @return 单例
     */
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {
        EnumSingleton instance_1 = EnumSingleton.getInstance();
        EnumSingleton instance_2 = EnumSingleton.getInstance();
        System.out.println(instance_1);
        System.out.println(instance_2);
    }

}
