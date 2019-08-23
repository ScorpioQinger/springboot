package com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName SpringDataTest
 * @Description TODO
 * @Author zq
 * @Date 2019/8/21 15:27
 * @Version 1.0
 **/
public class SpringDataTest {
    private ApplicationContext cxt;

    @Before
    public void setUp(){
        cxt = new ClassPathXmlApplicationContext("springdata.xml");
        System.out.println("========== setUp ==========");
    }

    @After
    public void destory(){
        cxt = null;
        System.out.println("========== destory ==========");
    }

    @Test
    public void testEntityManagerFactory(){

    }
}
