package com.ycorn.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.ycorn.common.constant.ServiceName;
import com.ycorn.common.entity.CommonResult;
import com.ycorn.common.service.PaymentServiceFeignFacade;
import com.ycorn.service.fallback.PaymentServiceFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: wujianmin
 * @Date: 2020/3/17 10:00
 * @Function:
 * @Version 1.0
 */
//@FeignClient(value = ServiceName.PAYMENT_HYSTRIX_SERVICE_NAME, fallbackFactory = PaymentServiceFeignFallbackFactory.class)
@FeignClient(value = ServiceName.PAYMENT_HYSTRIX_SERVICE_NAME, fallback = PaymentServiceFeignClientFallback.class)
public interface PaymentServiceFeignClient extends PaymentServiceFeignFacade {
    @GetMapping("/payment/error/{name}")
    CommonResult error(@PathVariable("name") String name);

}
