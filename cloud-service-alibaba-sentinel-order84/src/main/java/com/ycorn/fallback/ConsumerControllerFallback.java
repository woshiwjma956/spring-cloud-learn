package com.ycorn.fallback;

import com.ycorn.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: wujianmin
 * @Date: 2020/3/25 14:57
 * @Function:
 * @Version 1.0
 */
@Slf4j
public class ConsumerControllerFallback {

    public static CommonResult defaultFallback(Integer id,Throwable e) {
        log.info(e.getMessage());
//        log.info(e.getCause().getMessage());
        return CommonResult.error("ConsumerControllerFallback# defaultFallback + id => " + id);
    }

    public static CommonResult consumerMethod2(Integer id,Throwable e) {
        log.info(e.getMessage());
        return CommonResult.error("ConsumerControllerFallback# consumerMethod2 + id => " + id);
    }
}
