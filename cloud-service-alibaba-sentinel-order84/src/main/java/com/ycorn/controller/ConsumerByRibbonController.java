package com.ycorn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ycorn.common.entity.CommonResult;
import com.ycorn.fallback.ConsumerControllerBlockHandler;
import com.ycorn.fallback.ConsumerControllerFallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: wujianmin
 * @Date: 2020/3/25 9:50
 * @Function:
 * @Version 1.0
 */
@RestController
@RequestMapping("order")
public class ConsumerByRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mic-service.payment}")
    private String urlPrefix;

    @Value("${server.port}")
    private String port;

    @SentinelResource(value = "ribbon_consumeSentinelCircuitBreaking",
            blockHandlerClass = ConsumerControllerBlockHandler.class,
            blockHandler = "defaultFallback",
            fallbackClass = ConsumerControllerFallback.class,
            fallback = "defaultFallback"
    )
    @GetMapping("ribbon/consumeSentinelCircuitBreaking/{id}")
    public CommonResult consumeSentinelCircuitBreaking(@PathVariable("id") Integer id) {
        CommonResult result = restTemplate.getForObject(urlPrefix + "/sentinel/testCircuitBreaking/" + id, CommonResult.class);
        return CommonResult.success("receive data by ribbion from port " + port, result);
    }

    @SentinelResource(value = "ribbon_testExceptionIgnore",
            blockHandlerClass = ConsumerControllerBlockHandler.class,
            blockHandler = "defaultFallback",
            fallbackClass = ConsumerControllerFallback.class,
            fallback = "defaultFallback",
            exceptionsToIgnore = IllegalArgumentException.class
    )
    @GetMapping("/testExceptionIgnore/{id}")
    public CommonResult testExceptionIgnore(@PathVariable("id") Integer id) {
        if (id == 4) {
            throw new IllegalArgumentException("参数错误");
        }
        if (id > 4) {
           throw new IllegalStateException("状态异常");
        }
        CommonResult result = restTemplate.getForObject(urlPrefix + "/sentinel/testCircuitBreaking/" + id, CommonResult.class);
        return CommonResult.success("receive data by ribbion from port " + port, result);
    }

}
