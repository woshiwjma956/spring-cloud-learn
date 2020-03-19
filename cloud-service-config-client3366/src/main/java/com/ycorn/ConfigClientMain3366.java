package com.ycorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: wujianmin
 * @Date: 2020/3/19 10:42
 * @Function:
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient

public class ConfigClientMain3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class, args);
    }

}
