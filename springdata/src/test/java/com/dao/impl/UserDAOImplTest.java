package com.dao.impl;

import com.dao.UserDAO;
import com.domain.User;
import com.utils.SnowflakeIdWorker;
import org.junit.Test;
import java.util.List;


public class UserDAOImplTest {

    @Test
    public void findAll() {
        UserDAO userDAO = new UserDAOImpl();
        List<User> users = userDAO.findAll();
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void save(){
        UserDAO userDAO = new UserDAOImpl();
        User user = new User();
        user.setUid(new SnowflakeIdWorker(1,1).nextId());
        user.setName("赤木晴子");
        user.setMobile("17647586932");
        user.setIdCard("130151199411055865");
        user.setRoles(3);
        user.setPwd("123456");
        userDAO.save(user);
    }
}