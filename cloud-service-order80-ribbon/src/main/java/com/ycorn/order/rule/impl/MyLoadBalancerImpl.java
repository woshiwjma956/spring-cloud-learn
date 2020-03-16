package com.ycorn.order.rule.impl;

import com.ycorn.order.rule.MyLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wujianmin
 * @Date: 2020/3/16 10:40
 * @Function:
 * @Version 1.0
 */
@Component
public class MyLoadBalancerImpl implements MyLoadBalancer {

    private AtomicInteger nextServerIndex;

    public MyLoadBalancerImpl() {
        this.nextServerIndex = new AtomicInteger(0);
    }

    public final int getNext() {
        int current;
        int next;
        do {
            current = nextServerIndex.get();
            next = current + 1;
        } while (!this.nextServerIndex.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance select(List<ServiceInstance> serviceInstances) {
        if (CollectionUtils.isEmpty(serviceInstances)) throw new RuntimeException("all Service has down..");
        int next = this.getNext();
        return serviceInstances.get(next%serviceInstances.size());
    }
}
