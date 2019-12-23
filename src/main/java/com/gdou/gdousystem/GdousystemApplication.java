package com.gdou.gdousystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gdou.gdousystem.dao")
public class GdousystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdousystemApplication.class, args);
    }

}
