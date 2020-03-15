package com.ycorn.controller;

import com.ycorn.common.entity.CommonResult;
import com.ycorn.common.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 17:35
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final String paymentUrl = "http://" + "cloud-server-payment".toUpperCase();

    @Autowired
    RestTemplate restTemplate;


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

}