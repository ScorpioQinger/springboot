package com.dao.impl;

import com.dao.UserDAOSpringJdbc;
import com.domain.User;
import com.utils.SnowflakeIdWorker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class UserDAOSpringJdbcImplTest {
    private ApplicationContext cxt;
    private UserDAOSpringJdbc userDAOSpringJdbc;

    @Before
    public void setup(){
        cxt = new ClassPathXmlApplicationContext("beans.xml");
        userDAOSpringJdbc = (UserDAOSpringJdbc)cxt.getBean("userDAOSpringJdbc");
        System.out.println("========== setup ==========");
    }

    @After
    public void destory(){
        cxt = null;
        System.out.println("========== destory ==========");
    }

    @Test
    public void findAll() {
        List<User>users = userDAOSpringJdbc.findAll();
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void save() {
        User user = new User();
        user.setUid(new SnowflakeIdWorker(1,1).nextId());
        user.setName("宫城良太");
        user.setMobile("17647586365");
        user.setIdCard("130151199510055865");
        user.setRoles(3);
        user.setPwd("123456");
        userDAOSpringJdbc.save(user);
    }
}