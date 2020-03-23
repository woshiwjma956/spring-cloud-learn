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

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/{id}")
    public CommonResult findById(@PathVariable("id") Long id) {
        Payment payment = paymentService.findById(id);
        if (null == payment) {
            return CommonResult.error();
        } else {
            return CommonResult.success("成功获取数据 port: " + port, payment);
        }
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        Long result = paymentService.create(payment);
        if (null == result) {
            return CommonResult.error();
        } else {
            return CommonResult.success("成功插入数据 port: " + port, result);
        }
    }

    @GetMapping("/timeout/{id}")
    public CommonResult timeOut(@PathVariable("id") Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Payment payment = paymentService.findById(id);
        if (null == payment) {
            return CommonResult.error();
        } else {
            return CommonResult.success("成功获取数据 port But Time Out: " + port, payment);
        }
    }

    @GetMapping("/lb")
    public CommonResult lbTest() {
        return CommonResult.success(port);
    }


    @Value("${config.info}")
    public String nacosConfigInfo;

    @GetMapping("/nacos/config")
    public CommonResult nacosConfig() {
        return CommonResult.success("成功从Nacos获取数据: " + port, "nacos.config.info=>" + nacosConfigInfo);
    }
}