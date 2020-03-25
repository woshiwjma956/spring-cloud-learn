package com.ycorn.payment.controller;

import com.ycorn.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author JimWu
 * @create 2020-03-14 16:40
 */
@RestController
@RequestMapping("/circuitBreaking")
@RefreshScope
@Slf4j
public class CircuitBreakingController {


    @Value("${server.port}")
    private String port;

    /**
     * 1.  1s 内持续进入 5 个请求
     * 2. 对应时刻的平均响应时间（秒级）均超过阈值（count，以 ms 为单位）
     * 3. 在接下的时间窗口（DegradeRule 中的 timeWindow，以 s 为单位）之内，对这个方法的调用都会自动地熔断（抛出 DegradeException）。
     * <p>
     * RT 上限是 4900 ms，超出此阈值的都会算作 4900 ms，若需要变更此上限可以通过启动配置项 -Dcsp.sentinel.statistic.max.rt=xxx 来配置
     *
     * @return
     */
    @GetMapping("sentinel/RT")
    public CommonResult RT() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")) + " receive from " + port + "sentinel RT");

        return CommonResult.success("receive from " + port, "sentinel RT");
    }

    /**
     * 1. 当资源的每秒请求量 >= 5
     * 2. 每秒异常总数占通过量的比值超过阈值（DegradeRule 中的 count）之后
     * 3. 资源进入降级状态，即在接下的时间窗口（DegradeRule 中的 timeWindow，以 s 为单位）之内，对这个方法的调用都会自动地返回。
     *
     * 异常比率的阈值范围是 [0.0, 1.0]，代表 0% - 100%。
     * @return
     */
    @GetMapping("sentinel/exceptionRate")
    public CommonResult exceptionRate() {
        log.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")) + " receive from " + port + "sentinel exceptionRate");
        int nextInt = ThreadLocalRandom.current().nextInt();
        if (nextInt % 2 == 0) throw new RuntimeException("error !");
        return CommonResult.success("receive from " + port, "sentinel exceptionRate");
    }

    /**
     *  配置时间窗口需要大于60S
     *  当资源近 1 分钟的异常数目超过阈值之后会进行熔断。注意由于统计时间窗口是分钟级别的，若 timeWindow 小于 60s，则结束熔断状态后仍可能再进入熔断状态。
     * @return
     */
    @GetMapping("sentinel/exceptionCount")
    public CommonResult exceptionCount() {
        log.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ")) + " receive from " + port + "sentinel exceptionCount");
//        int nextInt = ThreadLocalRandom.current().nextInt();
//        if (nextInt % 2 == 0) throw new RuntimeException("error !");
        int age = 10/0;
        return CommonResult.success("receive from " + port, "sentinel exceptionCount");
    }
}