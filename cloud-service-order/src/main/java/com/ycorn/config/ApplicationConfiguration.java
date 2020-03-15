package com.ycorn.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 17:36
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    @LoadBalanced // 开启RestTemplate 的负载均和机制,如果直接使用springCloud注册在eureka上的application.name需要加入该注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}