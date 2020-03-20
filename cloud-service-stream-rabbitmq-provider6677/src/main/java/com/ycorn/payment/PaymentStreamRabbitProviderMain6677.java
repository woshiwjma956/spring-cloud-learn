package com.ycorn.payment;

import com.ycorn.payment.service.impl.PaymentServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 15:58
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.ycorn.payment.dao"})
public class PaymentStreamRabbitProviderMain6677 {

    public static void main(String[] args) {
                SpringApplication.run(PaymentStreamRabbitProviderMain6677.class, args);
    }

}