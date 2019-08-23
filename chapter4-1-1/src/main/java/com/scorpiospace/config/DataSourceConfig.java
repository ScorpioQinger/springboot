package com.scorpiospace.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfig
 * @Description TODO
 * @Author zq
 * @Date 2019/8/23 15:23
 * @Version 1.0
 **/
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean(name = "lineDataSource")// 将对象放再Spring容器中
    @Qualifier("lineDataSource") // 表示查找Spring容器中名字为lineDataSource的对象
    @Primary// 默认的数据源
    @ConfigurationProperties(prefix = "spring.datasource.line")// 读取application.properties中的配置参数映射成一个对象
    public DataSource lineDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("lineJdbcTemplate")
    @Primary
    public JdbcTemplate lineJdbcTemplate(){
        JdbcTemplate template = new JdbcTemplate(lineDataSource());
        return  template;
    }


    @Bean(name = "localDataSource")
    @Qualifier("lineDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource localDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "localJdbcTemplate")
    public JdbcTemplate localJdbcTemplate(){
        JdbcTemplate template = new JdbcTemplate(localDataSource());
        return template;
    }
}
