package com.ycorn.controller;

import com.ycorn.common.entity.CommonResult;
import com.ycorn.common.entity.Payment;
import com.ycorn.service.PaymentServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private PaymentServiceFeignClient paymentServiceClient;

    @GetMapping("/consumer/payment/{paymentId}")
    public CommonResult consumePaymentFindById(@PathVariable("paymentId") Long paymentId) {
        CommonResult result = paymentServiceClient.findById(paymentId);
        return Objects.nonNull(result) ? CommonResult.success(result.getMessage(), result.getData()) : CommonResult.error();
    }

    @PostMapping("/consumer/payment/create")
    public CommonResult consumePaymentCreate(@RequestBody Payment payment) {
        CommonResult result = paymentServiceClient.create(payment);
        return Objects.nonNull(result) ? CommonResult.success(result.getMessage(), result.getData()) : CommonResult.error();
    }

    @GetMapping("/consumer/payment/timeout/{paymentId}")
    public CommonResult consumePaymentTimeout(@PathVariable("paymentId") Long paymentId) throws InterruptedException {
        CommonResult result = paymentServiceClient.timeOut(paymentId);
        return Objects.nonNull(result) ? CommonResult.success(result.getMessage(), result.getData()) : CommonResult.error();
    }

    @GetMapping("/consumer/payment/errorTimeout/{name}")
    public CommonResult errorTimeout(@PathVariable("name") String name) throws InterruptedException {
        CommonResult result = paymentServiceClient.error(name);
        return Objects.nonNull(result) && result.getCode() == 200 ? CommonResult.success(result.getMessage(), result.getData()) : CommonResult.error(result.getCode(), result.getMessage());
    }
}