package com.luuo.imovs.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@MapperScan(value = "com.luuo.imovs.user.mapper")
@ComponentScan(value = "com.luuo.imovs")
public class ImovsUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImovsUserApplication.class, args);
    }

}
