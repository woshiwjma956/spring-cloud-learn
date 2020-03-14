package com.ycorn.payment.controller;

import com.ycorn.common.entity.CommonResult;
import com.ycorn.common.entity.Payment;
import com.ycorn.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 16:40
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public CommonResult findById(@PathVariable("id") Long id) {
        return CommonResult.success(paymentService.findById(id));
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return CommonResult.success(paymentService.create(payment));
    }

}