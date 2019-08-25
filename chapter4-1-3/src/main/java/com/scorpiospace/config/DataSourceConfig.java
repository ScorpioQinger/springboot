package com.scorpiospace.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:config/db.properties"})
public class DataSourceConfig {

}
