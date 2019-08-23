package com.scorpiospace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Chapter411Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter411Application.class, args);
    }

}
