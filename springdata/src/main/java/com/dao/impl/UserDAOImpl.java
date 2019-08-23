package com.dao.impl;

import com.dao.UserDAO;
import com.domain.User;
import com.utils.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserDAOImpl
 * @Description TODO UserDAO接口访问的实现类：通过最原始的JDBC方式操作
 * @Author zq
 * @Date 2019/8/21 10:07
 * @Version 1.0
 **/
public class UserDAOImpl implements UserDAO {

    /**
     * @Description   TODO 获取用户列表
     * @Author:       zq
     * @Date:         2019/8/21 10:19
     * @param:        []
     * @return:       java.util.List<com.domain.User>
     **/
    public List<User> findAll() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from u_user";
        List <User> users = new ArrayList<User>();
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                Long uid = rs.getLong("u_id");
                String name = rs.getString("u_name");
                String idCard = rs.getString("id_card");
                String mobile = rs.getString("mobile");
                String pwd = rs.getString("pwd");
                Integer roles = rs.getInt("roles");
                Date regTime = rs.getTimestamp("reg_time");
                User user = new User();
                user.setId(id);
                user.setUid(uid);
                user.setName(name);
                user.setIdCard(idCard);
                user.setMobile(mobile);
                user.setPwd(pwd);
                user.setRoles(roles);
                user.setRegTime(regTime);
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.release(rs,ps,connection);
        }
        return users;
    }

    /**
     * @Description   TODO 新增用户
     * @Author:       zq
     * @Date:         2019/8/21 10:40
     * @param:        [user]
     * @return:       void
     **/
    public void save(User user) {
        Connection connection = null;
        PreparedStatement ps = null;
        String sql = "insert into u_user(u_id,u_name,id_card,mobile,pwd,roles) values(?,?,?,?,?,?)";
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setLong(1,user.getUid());
            ps.setString(2,user.getName());
            ps.setString(3,user.getIdCard());
            ps.setString(4,user.getMobile());
            ps.setString(5,user.getPwd());
            ps.setInt(6,user.getRoles());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(null,ps,connection);
        }
    }
}
