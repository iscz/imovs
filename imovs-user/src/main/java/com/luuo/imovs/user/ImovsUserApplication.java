package com.luuo.imovs.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.luuo.imovs.user.mapper")
public class ImovsUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImovsUserApplication.class, args);
    }

}
