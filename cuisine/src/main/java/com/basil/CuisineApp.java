package com.basil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ${USER}
 * @create ${DATE} ${TIME}
 * @description com.basil ${PROJECT_NAME}
 */
@SpringBootApplication
@MapperScan("com.basil.mapper")
public class CuisineApp {
    public static void main(String[] args) {
        SpringApplication.run(CuisineApp.class, args);
    }
}