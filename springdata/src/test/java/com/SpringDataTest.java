package com;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class SpringDataTest {
    private ApplicationContext cxt;

    @Before
    public void setUp(){
        cxt = new ClassPathXmlApplicationContext("springdata.xml");
        log.info("========== setUp ==========");
    }

    @After
    public void destory(){
        cxt = null;
        log.info("========== destory ==========");
    }

    @Test
    public void testEntityManagerFactory(){

    }
}
