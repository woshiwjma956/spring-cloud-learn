package com.ycorn.payment.controller;

import com.ycorn.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@Slf4j
public class FlowLimitController {


    @Value("${server.port}")
    private String port;

    /**
     * 测试QPS
     * @return
     */
    @GetMapping("sentinel/QPS")
    public CommonResult QPS() {
        return CommonResult.success("receive from " + port, "sentinel QPS");
    }

    /**
     * 测试 thread threshold
     * @return
     */
    @GetMapping("sentinel/threadThreshold")
    public CommonResult threadThreshold() {
        try {
            TimeUnit.MILLISECONDS.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("receive from " + port + "sentinel threadThreshold");
        return CommonResult.success("receive from " + port, "sentinel threadThreshold");
    }

    @GetMapping("sentinel/warmUp")
    public CommonResult warmUp(){
        log.info("receive from " + port + "sentinel warmUp");
        return CommonResult.success("receive from " + port, "sentinel warmUp");
    }

    @GetMapping("sentinel/rateLimit")
    public CommonResult rateLimit(){
        log.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")) +" receive from " + port + "sentinel rateLimit");

        return CommonResult.success("receive from " + port, "sentinel rateLimit");
    }
}