package com.ycorn.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 21:21
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7002.class, args);
    }
}