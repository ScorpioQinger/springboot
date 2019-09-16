package com.scorpiospace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = {"com.scorpiospace.dao"})
public class Chapter421Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter421Application.class, args);
    }

}
