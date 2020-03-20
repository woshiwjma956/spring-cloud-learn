package com.ycorn.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author: wujianmin
 * @Date: 2020/3/20 15:43
 * @Function:
 * @Version 1.0
 */
public interface DestStream {

    String CHANNEL_NAME= "stream_provider_channel";

    @Input(CHANNEL_NAME)
    SubscribableChannel input();;

}
