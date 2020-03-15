package com.ycorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述:
 *
 * @author JimWuppo
 * @create 2020-03-15 19:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8004.class, args);
    }

}