package com.learn.designpattern.factory.abstractfactory.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @Description: 连接池抽象类
 * 自定义连接池
 * getInstance()返回POOL的唯一实例，第一次调用时将执行构造函数
 * 构造函数Pool()调用驱动装载loadDrivers()函数
 * 连接池创建createPool()函数，loadDrivers()装载驱动
 * createPool()创建连接池，getConnection()返回一个连接实例.
 * getConnection(long time)添加时间限制
 * freeConnection(Connection con)将con连接实例返回连接池
 * getnum()返回空闲连接数
 * getnumActive()返回当前使用的连接数
 * @Author: chenfuyuan
 * @Date: 2021/4/20 21:38
 */
public abstract class Pool {
    /**
     * 配置名称
     */
    protected String propertiesName = "/connection-INF.properties";

    /**
     * 唯一实例
     */
    private static Pool instance = null;

    /**
     * 最大连接数
     */
    protected int maxConnect = 100;

    /**
     * 保持连接数
     */
    protected int normalConnect = 10;

    /**
     * 驱动字符串
     */
    protected String driverName = null;

    /**
     * 驱动类
     */
    protected Driver driver = null;

    /**
     * 配置键-数据库驱动类
     */
    protected final static String PROPERTIES_DRIVERNAME = "driverName";

    /**
     * 配置键-最大连接数
     */
    protected final static String PROPERTIES_MAX_CONNECT = "maxConnect";

    /**
     * 配置键-保持连接数
     */
    protected final static String PROPERTIES_NORMAL_CONNECT = "normalConnect";

    /**
     * 默认数据库连接池路径
     */
    private final static String DEFAULT_POOL_INSTANCE_CLASS_PATH = "";


    /**
     * 私有化构造器，防止外界访问
     */
    protected Pool() {
        try {
            //初始化配置
            this.init();
            //装载驱动
            loadDrivers(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化所有从配置文件中读取的成员变量
     * @throws IOException IO异常
     */
    private void init() throws IOException{
        InputStream is = Pool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.driverName = p.getProperty(PROPERTIES_DRIVERNAME);
        this.maxConnect = Integer.parseInt(p.getProperty(PROPERTIES_MAX_CONNECT));
        this.normalConnect = Integer.parseInt(p.getProperty(PROPERTIES_NORMAL_CONNECT));
    }


    /**
     * 装载和注册所有JDBC驱动程序
     * @param driverName 驱动类名
     */
    protected void loadDrivers(String driverName) {
        String driverClassName = driverName;
        try {
            driver = (Driver) Class.forName(driverClassName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动程序"+driverClassName);
        } catch (Exception e) {
            System.out.println("无法注册JDBC驱动程序"+driverClassName+",错误:"+e);
        }
    }

    /**
     * 创建连接池
     */
    public abstract void createPool();

    /**
     * (单例模式)返回数据库连接池Pool实例
     * @return 数据库连接池Pool实例
     * @throws IOException IO异常
     * @throws InstantiationException 实例化异常
     * @throws IllegalAccessException 非法访问异常
     * @throws ClassNotFoundException 类找不到异常
     */
    public static Pool getInstance() throws IOException,InstantiationException,IllegalAccessException,ClassNotFoundException{
        if (instance == null) {
            synchronized (Pool.class) {
                if (instance == null) {
                    instance = (Pool) Class.forName(DEFAULT_POOL_INSTANCE_CLASS_PATH).newInstance();
                }
            }
        }
        return instance;
    }

    /**
     * 获取一个可用连接，如果没有，则创建一个连接，并且小于最大连接限制
     * @return 可用连接
     */
    public abstract Connection getConnection();

    /**
     * 获取一个有时间限制的连接
     * @param time 设置连接的持续时间(以毫秒为单位)
     * @return 可用连接
     */
    public abstract Connection getConnection(long time);

    /**
     * 将连接对象放回连接池
     * @param connection 获得的连接对象
     */
    public abstract void freeConnection(Connection connection);

    /**
     * 返回当前空闲的连接数
     * @return 当前空闲的连接数
     */
    public abstract int getFreeNum();

    /**
     * 返回当前活动的连接数
     * @return 当前活动的连接数
     */
    public abstract int getActiveNum();

    /**
     * 关闭所有连接，撤销驱动注册(此方法为单例方法)
     */
    public synchronized void relase() {
        //撤销驱动
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销JDBC驱动程序"+driver.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("无法撤销JDBC驱动程序的注册:"+driver.getClass().getName());
        }

    }

}
