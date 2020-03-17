package com.ycorn.common.service;

import com.ycorn.common.entity.CommonResult;
import com.ycorn.common.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: wujianmin
 * @Date: 2020/3/17 10:00
 * @Function:
 * @Version 1.0
 */
public interface PaymentServiceFeignFacade {
    @GetMapping("/payment/{id}")
    CommonResult findById(@PathVariable("id") Long id);

    @PostMapping("/payment/create")
    CommonResult create(@RequestBody Payment payment);

    @GetMapping("/payment/timeout/{id}")
    CommonResult timeOut(@PathVariable("id") Long id) throws InterruptedException;

}
