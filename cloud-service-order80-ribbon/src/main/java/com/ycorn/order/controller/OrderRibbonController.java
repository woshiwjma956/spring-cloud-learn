package com.ycorn.order.controller;

import com.ycorn.common.entity.CommonResult;
import com.ycorn.common.entity.Payment;
import com.ycorn.order.rule.impl.MyLoadBalancerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

/**
 * @Author: wujianmin
 * @Date: 2020/3/16 10:30
 * @Function:
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderRibbonController {
    private static final String paymentUrl = "http://" + "cloud-server-payment".toUpperCase();

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    MyLoadBalancerImpl myLoadBalancer;

    @GetMapping("/consumer/payment/{paymentId}")
    public CommonResult consumePaymentFindById(@PathVariable("paymentId") Long paymentId) {
        CommonResult result = restTemplate.getForObject(paymentUrl + "/payment/" + paymentId, CommonResult.class);
        return Objects.nonNull(result) ? CommonResult.success(result.getMessage(), result.getData()) : CommonResult.error();
    }

    @PostMapping("/consumer/payment/create")
    public CommonResult consumePaymentCreate(@RequestBody Payment payment) {
        System.out.println(payment);
        CommonResult result = restTemplate.postForObject(paymentUrl + "/payment/create", payment, CommonResult.class);
        return Objects.nonNull(result) ? CommonResult.success(result.getMessage(), result.getData()) : CommonResult.error();
    }

    @GetMapping("/useMyLoadBalancer/payment/{paymentId}")
    public CommonResult useMyLoadBalancer(@PathVariable("paymentId") Long paymentId) {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("cloud-server-payment".toUpperCase());
        ServiceInstance serviceInstance = myLoadBalancer.select(serviceInstances);
        CommonResult result = restTemplate.getForObject(serviceInstance.getUri() + "/payment/" + paymentId, CommonResult.class);
        return Objects.nonNull(result) ? CommonResult.success(result.getMessage(), result.getData()) : CommonResult.error();
    }

}
