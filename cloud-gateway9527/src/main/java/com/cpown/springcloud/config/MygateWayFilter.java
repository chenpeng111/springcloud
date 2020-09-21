package com.cpown.springcloud.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MygateWayFilter implements GlobalFilter, Ordered {

    /**
     * 类似于 过滤器interceptor 可以对请求进行判断，增强，以及校验
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String name = request.getQueryParams().getFirst("name");
        //如果参数为 空 不予通过 直接报错
        if (StringUtils.isEmpty(name)) {
            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 此方法仅设置排序顺序无需改动
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
