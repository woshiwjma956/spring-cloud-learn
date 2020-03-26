package com.ycorn.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.ycorn.entity.Order;
import com.ycorn.mapper.OrderMapper;
import com.ycorn.service.AccountService;
import com.ycorn.service.OrderService;
import com.ycorn.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: wujianmin
 * @Date: 2020/3/26 11:26
 * @Function:
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
        log.info("创建订单");
        orderMapper.insert(order);
        log.info("创建订单 END");
        log.info("库存扣除");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("库存扣除 END");
        log.info("账户余额扣除");
        accountService.decrease(order.getUserId(), order.getMoney().multiply(new BigDecimal(order.getCount())));
        log.info("账户余额扣除 END");
        this.update(order.getId(), order.getUserId(), 1);
    }

    @Override
    public void update(Long id, Long userId, Integer status) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("id", id);
        Order order = orderMapper.selectOne(queryWrapper);
        order.setStatus(1);
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(Order::getId, id).eq(Order::getUserId, userId);
        orderMapper.update(order, updateWrapper);
    }
}
