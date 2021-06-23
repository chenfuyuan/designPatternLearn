package com.learn.designpattern.proxy.bean;

/**
 * @Description: 动态数据源
 * @Author: chenfuyuan
 * @Date: 2021/6/23 19:52
 */
public class DynamicDataSourceEntry {

    public final static String DEFAULT_SOURCE = null;

    public final static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntry() {

    }

    /**
     * 清空数据源
     */
    public static void clear() {
        local.remove();
    }

    /**
     * 获取当前正在使用的数据源名字
     * @return
     */
    public static String get() {
        return local.get();
    }

    /**
     * 还原当前切换的数据源
     */
    public static void restore() {
        local.set(DEFAULT_SOURCE);
    }

    public static void set(String source) {
        local.set(source);
    }

    public static void set(int year) {
        local.set("DB_" + year);
    }




}
