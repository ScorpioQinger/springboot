package com.scorpiospace.dao.impl;

import com.scorpiospace.dao.UserDao;
import com.scorpiospace.domain.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
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
        return jdbcTemplate.update("insert into u_user(u_id,u_name,u_idcard,u_mobile,u_pwd,u_roles) " +
                "values(?,?,?,?,?,?) ",user.getUid(),user.getName(),user.getMobile(),user.getMobile(),user.getRoles());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("update u_user set u_name = ?,u_mobile = ? where u_id = ?",
                user.getName(),user.getMobile(),user.getUid());
    }

    @Override
    public int delete(Long uid) {
        return jdbcTemplate.update("delete from u_user where u_id = ?",uid);
    }

    @Override
    public User findUser(Long uid) {
        List<User> list = jdbcTemplate.query("select * from u_user where u_id = ?",new Object[]{uid},
                new BeanPropertyRowMapper(User.class));
        if(null != list && list.size() > 0){
            User user = list.get(0);
            return user;
        }else{
            return null;
        }
    }

    @Override
    public List<User> findUserList() {
        List<User> list = jdbcTemplate.query("select * from u_user",new Object[]{},new BeanPropertyRowMapper<User>(User.class));
        return list;
    }
}
