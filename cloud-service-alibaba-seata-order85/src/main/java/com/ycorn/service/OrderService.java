package com.ycorn.service;

import com.ycorn.entity.Order;

public interface OrderService {

    void create(Order order);

    void update(Long id, Long userId, Integer status);
}