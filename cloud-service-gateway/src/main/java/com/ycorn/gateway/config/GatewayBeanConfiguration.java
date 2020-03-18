package com.ycorn.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wujianmin
 * @Date: 2020/3/18 15:14
 * @Function:
 * @Version 1.0
 */
@Configuration
public class GatewayBeanConfiguration {
    /**
     *    - id: baidu_route_guoji
     *      uri: http://news.baidu.com/guoji
     *      predicates:
     *        - Path=/guoji
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator baiduRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("baidu_route_guoji",
                        r->r.path("/guoji").and().cookie("username","test")
                .filters(f->f.addRequestHeader("addHeader","myAddHeader"))
                .uri("http://news.baidu.com/guoji"))
                .route("baidu_route_sport",
                        r->r.path("/sports")
                .uri("http://news.baidu.com/sports"))
                .build();
    }

}
