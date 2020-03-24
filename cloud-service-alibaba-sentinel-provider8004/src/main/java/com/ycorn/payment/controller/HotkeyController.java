package com.ycorn.payment.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ycorn.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/hotkey")
@RefreshScope
@Slf4j
public class HotkeyController {


    @Value("${server.port}")
    private String port;

    /**
     * 测试QPS
     *
     * @return
     */
    @GetMapping("sentinel/hotkey")
    @SentinelResource(value = "hotkey",blockHandler  = "hotkey_BlockHandler")
    public CommonResult hotkey(@RequestParam(value = "p1", required = false) String p1,
                               @RequestParam(value = "p2", required = false) String p2) {
        return CommonResult.success("receive from " + port, "sentinel hotkey " + p1 + " " + p2);
    }

    public CommonResult hotkey_BlockHandler(String p1,
                                            String p2,
                                            BlockException e) {
        return CommonResult.error("receive from " + port + " sentinel hotkey fallback!!! " + p1 + " " + p2);
    }

}