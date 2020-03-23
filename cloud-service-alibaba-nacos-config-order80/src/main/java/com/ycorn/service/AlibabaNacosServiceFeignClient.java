package com.ycorn.service;

import com.ycorn.common.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: wujianmin
 * @Date: 2020/3/23 15:00
 * @Function:
 * @Version 1.0
 */
@FeignClient("cloud-service-alibaba-payment")
@Service
public interface AlibabaNacosServiceFeignClient {

    @GetMapping("payment/nacos/config")
    CommonResult nacosConfig();

}
