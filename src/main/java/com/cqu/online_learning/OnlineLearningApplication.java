package com.cqu.online_learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.cqu.online_learning.utils.StaticUtils.getMD5;

@SpringBootApplication
@MapperScan("com.cqu.online_learning.mapper")
public class OnlineLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineLearningApplication.class, args);
    }
}
