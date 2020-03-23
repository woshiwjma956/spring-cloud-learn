package com.ycorn.payment.controller;

import com.ycorn.common.entity.CommonResult;
import com.ycorn.common.entity.Payment;
import com.ycorn.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 16:40
 */
@RestController
@RequestMapping("/payment")
@RefreshScope
public class PaymentController {


    @Value("${server.port}")
    private String port;

    @GetMapping("sentinel/testA")
    public CommonResult testA() {
        return CommonResult.success("receive from " + port, "sentinel testA");
    }

    @GetMapping("sentinel/testB")
    public CommonResult testB() {
        return CommonResult.success("receive from " + port, "sentinel testB");
    }
}