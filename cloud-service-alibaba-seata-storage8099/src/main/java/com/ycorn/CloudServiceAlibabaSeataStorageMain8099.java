package com.ycorn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: wujianmin
 * @Date: 2020/3/26 14:23
 * @Function:
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.ycorn.dao"})
public class CloudServiceAlibabaSeataStorageMain8099 {
    public static void main(String[] args) {
        SpringApplication.run(CloudServiceAlibabaSeataStorageMain8099.class, args);
    }

}
