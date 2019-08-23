package com.dao.impl;

import com.dao.UserDAOSpringJdbc;
import com.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserDAOSpringJdbcImpl
 * @Description TODO UserDAOSpringJdbc接口访问的实现类：通过Spring Jdbc的哪个是操作
 * @Author zq
 * @Date 2019/8/21 11:32
 * @Version 1.0
 **/
public class UserDAOSpringJdbcImpl implements UserDAOSpringJdbc {
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        final List<User> users = new ArrayList<User>();
        String sql = "select * from u_user";
        jdbcTemplate.query(sql,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
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
        });
        return users;
    }

    public void save(User user) {
        String sql = "insert into u_user(u_id,u_name,id_card,mobile,pwd,roles) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{user.getUid(),user.getName(),user.getIdCard(),
                                             user.getMobile(),user.getPwd(),user.getRoles()});
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
