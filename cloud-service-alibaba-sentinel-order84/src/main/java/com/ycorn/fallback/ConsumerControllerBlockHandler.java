package com.ycorn.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ycorn.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

/**
 * @Author: wujianmin
 * @Date: 2020/3/25 11:14
 * @Function:
 * @Version 1.0
 */
@Slf4j
public class ConsumerControllerBlockHandler {

    public static CommonResult defaultFallback(Integer id,@NotNull BlockException e) {
        log.info(e.getMessage());
//        log.info(e.getCause().getMessage());
        return CommonResult.error("ConsumerControllerBlockHandler# defaultFallback + id => " + id);
    }

    public static CommonResult consumerMethod2(Integer id,@NotNull BlockException e) {
        System.out.println(e);
//        log.info(e.getCause().getMessage());
        return CommonResult.error("ConsumerControllerBlockHandler# consumerMethod2 + id => " + id);
    }

//public static CommonResult defaultFallback(Integer id ) {
////        log.info(e.getMessage());
////        log.info(e.getCause().getMessage());
//    return CommonResult.error("ConsumerControllerBlockHandler# defaultFallback + id => " + id);
//}
//
//    public static CommonResult consumerMethod2(Integer id) {
////        log.info(e.getMessage());
////        log.info(e.getCause().getMessage());
//        return CommonResult.error("ConsumerControllerBlockHandler# consumerMethod2 + id => " + id);
//    }
}
