package com.repository;

import com.domain.User;

import lombok.extern.java.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Log
public class UserRepositoryTest {
    private ApplicationContext cxt;
    private UserRepository userRepository;

    @Before
    public void setUp(){
        cxt = new ClassPathXmlApplicationContext("springdata.xml");
        userRepository = cxt.getBean(UserRepository.class);
        log.info("========== setUp ==========");
    }

    @After
    public void destroy(){
        cxt = null;
        log.info("========== destory ==========");
    }

    @Test
    public void findByName() {
        User user = userRepository.findByName("赤木晴子");
       log.info(user.toString());
    }
}