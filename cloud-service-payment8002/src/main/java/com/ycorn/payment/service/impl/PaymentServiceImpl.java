package com.ycorn.payment.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.ycorn.common.entity.Payment;
import com.ycorn.payment.dao.PaymentDao;
import com.ycorn.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 16:37
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public Long create(Payment payment) {
        int insert = paymentDao.insert(payment);
        return insert > 0 ? payment.getId() : 0L;
    }

    @Override
    public Payment findById(Long id) {
        System.out.println(123);
        return paymentDao.selectById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "testCircuitBreakerFallback",
            commandProperties = {
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true"), // 开启熔断器
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"), //快照时间测量请求的数量
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "10000"),// 快照时间
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "60"),// 错误率达到多少才开启熔断器
            })
    public String testCircuitBreaker(Integer index) {
        if (index % 2 == 0) {
            throw new RuntimeException("circuitBreaker error");
        }
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "index: " + index + "  id:" + IdUtil.simpleUUID();
    }

    public String testCircuitBreakerFallback(Integer index) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "index: " + index + " fallback!";
    }
}