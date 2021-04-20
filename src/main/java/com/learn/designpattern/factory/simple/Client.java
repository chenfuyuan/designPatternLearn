package com.learn.designpattern.factory.simple;


/**
 * @Description: 用户
 * @Author: chenfuyuan
 * @Date: 2021/4/20 18:28
 */
public class Client {

    public static void main(String[] args) {
        IProduct product = SimpleFactory.makeProduct(Const.PRODUCT_B);
        assert product != null;
        product.doSomething();
    }

    /**
     * 抽象产品
     */
    public interface IProduct {
        /**
         * 做某事
         */
        void doSomething();
    }

    /**
     * 具体产品A
     */
    static class ProductA implements IProduct {

        @Override
        public void doSomething() {
            System.out.println("我是产品A");
        }
    }

    /**
     * 具体产品B
     */
    static class ProductB implements IProduct {

        @Override
        public void doSomething() {
            System.out.println("我是产品B");
        }
    }

    /**
     * 具体产品C
     */
    static class ProductC implements IProduct {

        @Override
        public void doSomething() {
            System.out.println("我是产品C");
        }
    }

    /**
     * 常量
     */
    static final class Const {
        /**
         * 产品A代码
         */
        static final int PRODUCT_A = 0;
        /**
         * 产品B代码
         */
        static final int PRODUCT_B = 1;
        /**
         * 产品C代码
         */
        static final int PRODUCT_C = 2;
    }

    /**
     * 简单工厂
     */
    static class SimpleFactory {
        public static IProduct makeProduct(int kind) {
            switch (kind) {
                case Const.PRODUCT_A:
                    return new ProductA();
                case Const.PRODUCT_B:
                    return new ProductB();
                case Const.PRODUCT_C:
                    return new ProductC();
                default:
                    return null;
            }
        }
    }
}
