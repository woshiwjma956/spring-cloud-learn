package com.ycorn.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 15:58
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.ycorn.payment.dao"})
public class PaymentMain {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain.class, args);
    }

}