package com.cqu.online_learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqu.online_learning.mapper")
public class OnlineLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineLearningApplication.class, args);
    }
    //text:胡程斌是sb <-true
    //Iceistired死了亲妈！
    //请ice的儿子们不要诋毁你们的爹
    //每次run都有人司了马 是谁我不说
}
