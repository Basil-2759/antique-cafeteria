package com.basil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ${USER}
 * @create ${DATE} ${TIME}
 * @description com.basil ${PROJECT_NAME}
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.basil.api"})
@MapperScan("com.basil.mapper")
@RibbonClient("order-history")
public class OrderHistoryApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderHistoryApp.class, args);
    }
}