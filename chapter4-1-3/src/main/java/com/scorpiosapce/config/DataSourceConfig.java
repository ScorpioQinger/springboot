package com.scorpiosapce.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfig
 * @Description TODO 配置数据源（由于已经禁用掉自动数据源配置，所以这里手动创建数据源配置）
 * @Author zq
 * @Date 2019/8/23 14:26
 * @Version 1.0
 **/
@Configuration
public class DataSourceConfig {

    @Bean(name = "lineDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.line")
    public DataSource lineDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "localDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource localDataSource(){
        return DataSourceBuilder.create().build();
    }
}
