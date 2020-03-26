package com.ycorm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: wujianmin
 * @Date: 2020/3/26 11:47
 * @Function:
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.ycorm.dao"})
public class CloudServiceAlibabaSeataAccountMain8088 {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceAlibabaSeataAccountMain8088.class,args);
    }

}
