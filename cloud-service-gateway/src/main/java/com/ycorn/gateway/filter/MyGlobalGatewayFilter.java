package com.ycorn.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: wujianmin
 * @Date: 2020/3/18 16:30
 * @Function:
 * @Version 1.0
 */
@Component
@Slf4j
public class MyGlobalGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.debug("enter global gateway filter");
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (!StringUtils.isEmpty(token) && token.equals("access")) {
            return chain.filter(exchange);
        }
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
