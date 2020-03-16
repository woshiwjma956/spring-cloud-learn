package com.ycorn.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.ycorn.common.annotation.AvoidScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author: wujianmin
 * @Date: 2020/3/16 11:39
 * @Function:
 * @Version 1.0
 */
@Configuration
@AvoidScan
public class RibbonLoadBalanceConfiguration {

    /**
     * 随机规则
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
