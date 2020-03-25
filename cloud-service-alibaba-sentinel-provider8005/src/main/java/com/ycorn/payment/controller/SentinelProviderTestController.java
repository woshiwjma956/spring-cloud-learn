package com.ycorn.payment.controller;

import com.ycorn.common.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujianmin
 * @Date: 2020/3/25 9:53
 * @Function:
 * @Version 1.0
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelProviderTestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("testCircuitBreaking/{id}")
    public CommonResult testCircuitBreaking(@PathVariable("id") Integer id) {
        if (id % 2 == 0) {
            throw new IllegalArgumentException("参数异常!!");
        }
        return CommonResult.success("成功从Nacos获取数据: " + port, " id => " + id);

    }
}
