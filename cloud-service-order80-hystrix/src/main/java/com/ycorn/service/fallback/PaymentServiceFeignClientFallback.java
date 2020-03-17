package com.ycorn.service.fallback;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.ycorn.common.entity.CommonResult;
import com.ycorn.common.entity.Payment;
import com.ycorn.common.service.PaymentServiceFeignFacade;
import com.ycorn.service.PaymentServiceFeignClient;
import org.springframework.stereotype.Service;

/**
 * @Author: wujianmin
 * @Date: 2020/3/17 17:48
 * @Function:
 * @Version 1.0
 */
@Service
public class PaymentServiceFeignClientFallback implements PaymentServiceFeignClient {
    @Override
    public CommonResult findById(Long id) {
        return CommonResult.error("hystrix");
    }

    @Override
    public CommonResult create(Payment payment) {
        return CommonResult.error("hystrix");
    }

    @Override
    public CommonResult timeOut(Long id) throws InterruptedException {
        return CommonResult.error("hystrix");
    }

    @Override
    public CommonResult error(String name) {
        return CommonResult.error("hystrix # error");
    }
}
