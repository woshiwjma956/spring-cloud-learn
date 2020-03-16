package com.ycorn.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: wujianmin
 * @Date: 2020/3/16 10:25
 * @Function:
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderRibbonMain80 {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderRibbonMain80.class, args);
    }
}
