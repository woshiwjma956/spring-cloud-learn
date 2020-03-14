package com.ycorn.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 20:31
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7001.class,args);
    }

}