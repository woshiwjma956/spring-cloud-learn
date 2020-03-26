package com.ycorn.controller;

import com.ycorn.common.entity.CommonResult;
import com.ycorn.entity.Order;
import com.ycorn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujianmin
 * @Date: 2020/3/26 11:41
 * @Function:
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Order order)
    {
        orderService.create(order);
        return CommonResult.success(order);
    }
}
