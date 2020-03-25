package com.ycorn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ycorn.common.entity.CommonResult;
import com.ycorn.fallback.ConsumerControllerBlockHandler;
import com.ycorn.fallback.ConsumerControllerFallback;
import com.ycorn.service.SentinelPaymentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujianmin
 * @Date: 2020/3/25 9:47
 * @Function:
 * @Version 1.0
 */
@RestController
@RequestMapping("order")
public class ConsumerByFeignController {

    @Autowired
    private SentinelPaymentFeignClient sentinelPaymentFeignClient;

    @Value("${server.port}")
    private String port;

    @SentinelResource(value = "feigin_consumeSentinelCircuitBreaking",
            blockHandlerClass = ConsumerControllerBlockHandler.class,
            blockHandler = "consumerMethod2"
//            fallbackClass = ConsumerControllerFallback.class,
//            fallback = "consumerMethod2"
    )
    @GetMapping("feign/consumeSentinelCircuitBreaking/{id}")
    public CommonResult consumeSentinelCircuitBreaking(@PathVariable("id") Integer id) {
        return CommonResult.success("receive data by feign from port " + port, sentinelPaymentFeignClient.testCircuitBreaking(id));
    }
}
