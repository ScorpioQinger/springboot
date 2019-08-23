package com.repository;

import com.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserJpaRepositoryTest {
    private ApplicationContext cxt;
    private UserJpaRepository userJpaRepository;

    @Before
    public void setUp(){
        cxt = new ClassPathXmlApplicationContext("springdata.xml");
        userJpaRepository = cxt.getBean(UserJpaRepository.class);
        System.out.println("========== setUp ==========");
    }

    @After
    public void destroy(){
        cxt = null;
        System.out.println("========== destory ==========");
    }

    @Test
    public void testGetOne(){
       User user = userJpaRepository.getOne(1);
        System.out.println(user);
    }

}