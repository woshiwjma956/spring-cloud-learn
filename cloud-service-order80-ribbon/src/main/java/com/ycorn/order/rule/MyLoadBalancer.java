package com.ycorn.order.rule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: wujianmin
 * @Date: 2020/3/16 10:40
 * @Function:
 * @Version 1.0
 */
public interface MyLoadBalancer {

    ServiceInstance select(List<ServiceInstance> serviceInstances);
}
