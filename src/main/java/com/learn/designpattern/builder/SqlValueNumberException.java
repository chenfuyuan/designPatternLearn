package com.learn.designpattern.builder;

/**
 * @Description: Sql值数量错误
 * @Author: chenfuyuan
 * @Date: 2021/6/23 0:02
 */
public class SqlValueNumberException extends RuntimeException {
    public SqlValueNumberException(String message) {
        super(message);
    }

    public SqlValueNumberException() {
        super("Sql语句参数错误{值数量错误}");
    }
}
