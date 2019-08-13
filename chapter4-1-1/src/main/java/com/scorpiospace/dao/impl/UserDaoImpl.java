package com.scorpiospace.dao.impl;

import com.scorpiospace.dao.UserDao;
import com.scorpiospace.domain.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author zq
 * @Date 2019/8/9 17:14
 * @Version 1.0
 **/
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(User user) {
        System.err.println(user.toString());
        return jdbcTemplate.update("insert into u_user(u_id,u_name,id_card,mobile,pwd,roles) values(?,?,?,?,?,?) ",
                user.getUid(),user.getName(),user.getIdCard(),user.getMobile(),user.getPwd(),user.getRoles());
    }

    @Override
    public User insertGetKey(User user) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "insert into u_user(u_id,u_name,id_card,mobile,pwd,roles) values(?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1,user.getUid());
                ps.setString(2,user.getName());
                ps.setString(3,user.getIdCard());
                ps.setString(4,user.getMobile());
                ps.setString(5,user.getPwd());
                ps.setInt(6,user.getRoles());
                return ps;
            }
        },holder);
        int newId = holder.getKey().intValue();
        user.setId(newId);
        return user;
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("update u_user set u_name = ?,mobile = ? where u_id = ?",
                user.getName(),user.getMobile(),user.getUid());
    }

    @Override
    public int delete(Long uid) {
        return jdbcTemplate.update("delete from u_user where u_id = ?",uid);
    }

    @Override
    public User findUser(Long uid) {
        List<User> list = jdbcTemplate.query("select * from u_user where u_id = ?",new Object[]{uid},
                new User());
        if(null != list && list.size() > 0){
            User user = list.get(0);
            return user;
        }else{
            return null;
        }
    }

    @Override
    public User findUserByIdCard(String idCard) {
        List<User> list = jdbcTemplate.query("select * from u_user where id_card = ?",new Object[]{idCard},new User());
        if(null != list && list.size() > 0){
            User user = list.get(0);
            return user;
        }
        return null;
    }

    @Override
    public List<User> findUserList() {
        List<User> list = jdbcTemplate.query("select * from u_user",new Object[]{},new User());
        return list;
    }
}
