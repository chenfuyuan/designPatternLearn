package com.learn.designpattern.factory.abstractfactory.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * @Description: 实现的数据库连接池
 * @Author: chenfuyuan
 * @Date: 2021/4/20 22:11
 */
public class DbConnectionPool extends Pool {


    /**
     * 存放产生的连接对象容器
     */
    private Vector<Connection> freeConnections = new Vector<>();

    /**
     * 密码
     */
    private String password;

    /**
     * 连接的url
     */
    private String url;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 空闲的连接数
     */
    private static int freeNum;

    /**
     * 当前可用的连接数
     */
    private static int activeNum;

    /**
     * 连接池的实例变量
     */
    private static DbConnectionPool pool = null;

    /**
     * 配置键-用户名
     */
    protected final static String PROPERTIES_USERNAME = "userName";

    /**
     * 配置键-密码
     */
    protected final static String PROPERTIES_PASSWORD = "passWord";

    /**
     * 配置键-数据库驱动类
     */
    protected final static String PROPERTIES_DRIVERNAME = "driverName";

    /**
     * 配置键-数据库url
     */
    protected final static String PROPERTIES_URL = "url";

    /**
     * 配置键-最大连接数
     */
    protected final static String PROPERTIES_MAX_CONNECT = "maxConnect";

    /**
     * 配置键-保持连接数
     */
    protected final static String PROPERTIES_NORMAL_CONNECT = "normalConnect";

    /**
     * 获得一个数据库连接池实例
     */
    private DbConnectionPool() {
        try {
            //初始化配置
            this.init();
            //初始化连接池容器
            for (int i = 0; i < normalConnect; i++) {
                Connection c = newConnection();
                if (c != null) {
                    //往容器添加一个连接对象
                    freeConnections.addElement(c);
                    //记录总连接数
                    freeNum++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建一个连接
     *
     * @return 连接
     */
    private Connection newConnection() {
        Connection connection = null;
        try {
            if (userName == null) {
                connection = DriverManager.getConnection(url);
            } else {
                connection = DriverManager.getConnection(url, userName, password);
            }
            System.out.println("连接池创建一个新的连接");
            return connection;
        } catch (SQLException throwables) {
            System.out.println("无法创建这个URL的连接"+url);
        }
        return null;

    }

    /**
     * 初始化
     * @throws IOException IO异常
     */
    private void init() throws IOException {
        InputStream is = DbConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.userName = p.getProperty(PROPERTIES_USERNAME);
        this.password = p.getProperty(PROPERTIES_PASSWORD);
        this.url = p.getProperty(PROPERTIES_URL);
        this.driverName = p.getProperty(PROPERTIES_DRIVERNAME);
        this.maxConnect = Integer.parseInt(p.getProperty(PROPERTIES_MAX_CONNECT));
        this.normalConnect = Integer.parseInt(p.getProperty(PROPERTIES_NORMAL_CONNECT));
    }

    /**
     * 产生数据库连接池
     *
     * @return 数据库连接池
     */
    public static DbConnectionPool getInstance() {
        if (pool == null) {
            synchronized (DbConnectionPool.class) {
                if (pool == null) {
                    pool = new DbConnectionPool();
                }
            }
        }
        return pool;
    }

    @Override
    public void createPool() {
        pool = getInstance();
        if (pool != null) {
            System.out.println("创建连接池成功");
        } else {
            System.out.println("创建连接池失败");
        }
    }

    @Override
    public synchronized Connection getConnection() {
        Connection connection = null;
        if (freeConnections.size() > 0) {
            freeNum--;
            connection = freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (connection.isClosed()) {
                    System.out.println("从连接池删除一个无效连接");
                    connection = getConnection();
                }
            } catch (SQLException throwables) {
                System.out.println("从连接池删除一个无效连接");
                connection = getConnection();
            }

            //没有空闲连接且当前连接小于当前最大允许值,若最大值为0，则不限制
        } else if (maxConnect == 0 || activeNum < maxConnect) {
            connection = newConnection();
        }

        if (connection != null) {
            activeNum++;
        } else {
            System.out.println("匹配不到连接");
        }
        return connection;
    }

    @Override
    public Connection getConnection(long timeout) {
        long startTime = System.currentTimeMillis();
        Connection connection;
        while ((connection = getConnection()) == null) {
            try {
                wait(timeout);
            } catch (InterruptedException e) {
            }
            if (System.currentTimeMillis() - startTime >= timeout) {
                //如果超时就返回
                return null;
            }
        }
        return connection;
    }

    @Override
    public synchronized void freeConnection(Connection connection) {
        System.out.println("释放连接");
        freeConnections.addElement(connection);
        freeNum++;
        activeNum--;
        notifyAll();    //解锁
    }

    @Override
    public int getFreeNum() {
        return freeNum;
    }

    @Override
    public int getActiveNum() {
        return activeNum;
    }

    public synchronized void release() {
        try{
        Enumeration<Connection> allConnections = freeConnections.elements();
        while (allConnections.hasMoreElements()) {
            Connection connection = allConnections.nextElement();
            try {
                connection.close();
                freeNum--;
            } catch (SQLException throwables) {
                System.out.println("无法关闭连接池中的连接");
            }
        }
        freeConnections.removeAllElements();
        activeNum = 0;
        }finally {
            super.relase();
        }
    }
}
