package com.ycorn.payment.service.impl;

import com.ycorn.payment.stream.SourceStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Author: wujianmin
 * @Date: 2020/3/20 11:18
 * @Function:
 * @Version 1.0
 */
@EnableBinding(SourceStream.class)
public class ProviderMessageServiceImpl {

    @Autowired
    private SourceStream sourceStream;

    public void send(String msg) {
        Message<String> message = MessageBuilder.withPayload(msg).build();
        sourceStream.streamProviderChannel().send(message);
    }
}
