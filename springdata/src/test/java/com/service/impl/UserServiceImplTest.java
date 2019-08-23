package com.service.impl;

import com.domain.User;
import com.service.UserService;
import com.utils.SnowflakeIdWorker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.List;


public class UserServiceImplTest {
    private ApplicationContext cxt;
    private UserService userService;

    @Before
    public void setUp(){
        cxt = new ClassPathXmlApplicationContext("springdata.xml");
        userService = cxt.getBean(UserService.class);
        System.out.println("========== setUp ==========");
    }

    @After
    public void destroy(){
        cxt = null;
        System.out.println("========== destory ==========");
    }

    @Test
    public void testUpdatNameByUid() {
        userService.updatNameByUid("赤木刚宪",613739539235737600l);
    }
    @Test
    public void testSaveAll() {
        List<User> users = new ArrayList<User>();
        users.add(new User(new SnowflakeIdWorker(1,1).nextId(),"宫城良太",
                "18349262900","zhangsan","153632199302035689",3));
        users.add(new User(new SnowflakeIdWorker(1,1).nextId(),"三井寿",
                "18349262901","123456","153632199002035657",3));
        users.add(new User(new SnowflakeIdWorker(1,1).nextId(),"彩子",
                "18349262902","111111","153632199202035612",2));
        users.add(new User(new SnowflakeIdWorker(1,1).nextId(),"安西光义",
                "18349262903","zhangsan","153632189302035633",1));
        userService.saveAll(users);
    }

}