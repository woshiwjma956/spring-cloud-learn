package com.ycorn.order.controller;

import com.ycorn.common.constant.ServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-15 19:51
 */
@RestController
@RequestMapping("/order")
public class OrderConsulController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String zkTest() {
        return restTemplate.getForObject(ServiceName.getPrefixUrl(ServiceName.PAYMENT_CONSUL_SERVICE_NAME) + "payment/consul?name="+UUID.randomUUID().toString(), String.class);
    }

}