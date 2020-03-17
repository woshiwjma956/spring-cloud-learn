package com.ycorn.payment.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.ycorn.common.entity.Payment;
import com.ycorn.payment.dao.PaymentDao;
import com.ycorn.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;

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

    @HystrixCommand(fallbackMethod = "errorFallback",
            commandProperties = {
                    @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "5000")
            }
    )
    @Override
    public String error(String name) {
//        int age = 1 / 0;
        Long start = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + " ==> " + name + (start - System.currentTimeMillis());
    }

    public String errorFallback(String name) {
        return "Error Fallback return ==>" + name;
    }

}