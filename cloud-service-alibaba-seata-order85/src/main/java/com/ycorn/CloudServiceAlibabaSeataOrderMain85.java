package com.ycorn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: wujianmin
 * @Date: 2020/3/26 11:24
 * @Function:
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@MapperScan(basePackages = {"com.ycorn.mapper"})
public class CloudServiceAlibabaSeataOrderMain85 {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceAlibabaSeataOrderMain85.class, args);
    }

}
