package com.ycorn.listener;

import com.ycorn.stream.DestStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @Author: wujianmin
 * @Date: 2020/3/20 15:46
 * @Function:
 * @Version 1.0
 */
@EnableBinding(DestStream.class)
@Slf4j
public class MyStreamListener {

    @Value("${server.port}")
    private String port;

    @StreamListener(DestStream.CHANNEL_NAME)
    public void receive(String msg) {
        log.info("receive from provider" + msg + " port:" + port);
    }
}
