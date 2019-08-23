package com.scorpiosapce.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName MybatisDBLineConfig
 * @Description TODO 使用lineDataSource数据源配置Mybatis的SqlSessionFactory
 * @Author zq
 * @Date 2019/8/23 14:44
 * @Version 1.0
 **/
@Configuration
@MapperScan(basePackages = {"com.scorpiospace.mapper.line"},sqlSessionFactoryRef = "lineSqlSessionFactory")
public class MybatisDBLineConfig {
    @Autowired
    @Qualifier("lineDataSource")
    private DataSource lineDataSource;

    @Bean
    public SqlSessionFactory lineSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(lineDataSource);//使用line数据源，连接line数据库
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate lineSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(lineSqlSessionFactory());
        return template;
    }
}
