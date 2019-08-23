package com.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBCUtil 工具类
 * 1）创建Connection链接
 * 2）释放资源
 */
public class JDBCUtil {

    /**
     * 获取Connection
     * @return 所得到的JDBC的Connection
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {

        InputStream inputStream = JDBCUtil.class.getResourceAsStream("/db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("jdbc.url");
        String user =  properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);

        return  connection;
    }

    /**
     * 释放DB相关资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet,
                               Statement statement,Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
