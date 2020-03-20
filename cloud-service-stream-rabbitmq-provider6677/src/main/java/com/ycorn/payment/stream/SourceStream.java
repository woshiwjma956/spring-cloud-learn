package com.ycorn.payment.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Author: wujianmin
 * @Date: 2020/3/20 15:35
 * @Function:
 * @Version 1.0
 */
public interface SourceStream {

    String channelName= "stream_provider_channel";

    @Output(channelName)
    MessageChannel streamProviderChannel();
}
