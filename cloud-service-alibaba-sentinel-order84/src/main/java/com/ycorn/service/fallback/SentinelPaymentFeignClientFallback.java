package com.ycorn.service.fallback;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.fastjson.JSON;
import com.ycorn.common.entity.CommonResult;
import com.ycorn.service.SentinelPaymentFeignClient;
import org.springframework.stereotype.Component;

/**
 * @Author: wujianmin
 * @Date: 2020/3/25 15:58
 * @Function:
 * @Version 1.0
 */
@Component
public class SentinelPaymentFeignClientFallback implements SentinelPaymentFeignClient {
    @Override
    public CommonResult testCircuitBreaking(Integer id) {
        return CommonResult.error("SentinelPaymentFeignClientFallback # testCircuitBreaking " + id);
    }

}
