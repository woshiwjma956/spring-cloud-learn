package com.ycorn.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 15:58
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.ycorn.payment.dao"})
public class PaymentAlibabaNacosMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentAlibabaNacosMain8002.class, args);
    }

}