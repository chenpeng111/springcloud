package com.cpown.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 服务降级异常处理类
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String get(Long id) {
        return "服务器异常了：get";
    }

    @Override
    public String geterr(Long id) {
        return "服务器异常了：geterr";
    }
}
