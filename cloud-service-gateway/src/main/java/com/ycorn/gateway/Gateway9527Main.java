package com.ycorn.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: wujianmin
 * @Date: 2020/3/18 15:07
 * @Function:
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Gateway9527Main {

    public static void main(String[] args) {
        SpringApplication.run(Gateway9527Main.class, args);
    }

}
