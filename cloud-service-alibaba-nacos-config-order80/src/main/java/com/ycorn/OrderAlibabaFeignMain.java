package com.ycorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 17:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderAlibabaFeignMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderAlibabaFeignMain.class, args);
    }

}