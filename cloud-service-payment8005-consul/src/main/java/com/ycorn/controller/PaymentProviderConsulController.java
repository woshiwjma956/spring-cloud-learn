package com.ycorn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-15 19:46
 */
@RestController
@RequestMapping("/payment")
public class PaymentProviderConsulController {

    @Value("${server.port}")
    public String port;

    @GetMapping("/consul")
    public String providerZk(@RequestParam("name") String name) {
        return "Consume " + name + " from Consul " + port;
    }
}