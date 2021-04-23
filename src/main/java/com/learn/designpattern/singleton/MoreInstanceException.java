package com.learn.designpattern.singleton;

/**
 * @Description: 创建多个实例Exception
 * @Author: chenfuyuan
 * @Date: 2021/4/23 23:42
 */
public class MoreInstanceException extends RuntimeException {

    public MoreInstanceException() {
        super("This class have more instance!");
    }

    public MoreInstanceException(String message) {
        super(message);
    }


}
