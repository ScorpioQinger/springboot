package com.scorpiospace.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceConfigTest {
    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Test
    public void dataSource() {
        Assert.assertNotNull(dataSource);
    }
}