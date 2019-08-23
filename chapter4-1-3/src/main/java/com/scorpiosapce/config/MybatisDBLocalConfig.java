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
 * @ClassName MybatisDBLocalConfig
 * @Description TODO 使用localDataSource配置Mybatis的SqlSessionfactory
 * @Author zq
 * @Date 2019/8/23 15:03
 * @Version 1.0
 **/

@Configuration
@MapperScan(basePackages = "com.scorpiospace.mapper.local",sqlSessionFactoryRef = "localSqlSessionFactory")
public class MybatisDBLocalConfig {

    @Autowired
    @Qualifier("localDataSource")
    private DataSource localDataSource;

    @Bean
    public SqlSessionFactory localSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(localDataSource);//使用localDataSource数据源，连接local数据库
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate localSqlSessionTempalte() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(localSqlSessionFactory());
        return template;
    }

}
