package com.ycorn.payment.service.impl;

import com.ycorn.common.entity.Payment;
import com.ycorn.payment.dao.PaymentDao;
import com.ycorn.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}