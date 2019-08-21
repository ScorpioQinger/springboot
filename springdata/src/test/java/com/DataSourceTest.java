package com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

/**
 * @ClassName DataSource
 * @Description TODO
 * @Author zq
 * @Date 2019/8/21 11:18
 * @Version 1.0
 **/
public class DataSourceTest {
    private ApplicationContext cxt;

    @Before
    public void setup(){
        cxt = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("========== setup ==========");
    }

    @After
    public void destory(){
        cxt = null;
        System.out.println("========== destory ==========");
    }

    @Test
    public void dataSource(){
        DataSource dataSource = (DataSource) cxt.getBean("dataSource");
        Assert.assertNotNull(dataSource);
        System.out.println("dataSource");
    }

    @Test
    public void testJdbcTempalte(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate)cxt.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
        System.out.println("jdbcTemplate");
    }
}
