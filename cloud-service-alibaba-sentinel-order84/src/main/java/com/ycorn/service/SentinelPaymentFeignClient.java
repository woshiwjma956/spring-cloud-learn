package com.ycorn.service;

import com.ycorn.common.entity.CommonResult;
import com.ycorn.service.fallback.SentinelPaymentFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: wujianmin
 * @Date: 2020/3/25 9:51
 * @Function:
 * @Version 1.0
 */
@FeignClient(name = "cloud-service-alibaba-sentinel-provider", fallback = SentinelPaymentFeignClientFallback.class)
public interface SentinelPaymentFeignClient {

    @GetMapping("sentinel/testCircuitBreaking/{id}")
    CommonResult testCircuitBreaking(@PathVariable("id") Integer id);

}
