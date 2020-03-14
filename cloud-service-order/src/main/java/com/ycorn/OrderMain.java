package com.ycorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 17:35
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class, args);
    }

}