package com.cpown.springcloud.service;

import com.cpown.springcloud.dto.CommonResult;
import org.springframework.stereotype.Component;

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
