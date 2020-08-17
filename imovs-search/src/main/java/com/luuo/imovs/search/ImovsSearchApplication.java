package com.luuo.imovs.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.luuo.imovs.search.mapper")
public class ImovsSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImovsSearchApplication.class, args);
    }

}
