package com.ycorn.payment.service;


import com.ycorn.common.entity.Payment;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 16:38
 */
public interface PaymentService {

    Long create(Payment payment);

    Payment findById(Long id);

}