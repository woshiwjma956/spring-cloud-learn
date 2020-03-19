package com.ycorn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wujianmin
 * @Date: 2020/3/19 10:39
 * @Function:
 * @Version 1.0
 */
@RestController
@RequestMapping("/configClient")
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config/info")
    public Map getConfigInfoFromConfigServer(){
        Map<String,String> data = new ConcurrentHashMap<>();
        data.put("port",port);
        data.put("configInfo",configInfo);
        return data;
    }
}
