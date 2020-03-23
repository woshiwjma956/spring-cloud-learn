package com.ycorn.service;

import com.ycorn.common.constant.ServiceName;
import com.ycorn.common.service.PaymentServiceFeignFacade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * @Author: wujianmin
 * @Date: 2020/3/17 10:00
 * @Function:
 * @Version 1.0
 */
@FeignClient(ServiceName.PAYMENT_BASE_SERVICE_NAME)
@Service
public interface PaymentServiceFeignClient extends PaymentServiceFeignFacade {

}
