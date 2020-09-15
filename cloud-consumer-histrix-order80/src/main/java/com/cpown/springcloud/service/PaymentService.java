package com.cpown.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient 微服务接口调用类
 */
@FeignClient(value = "cloud-payment-hystrix-service",fallback = PaymentFallbackService.class)
@Component
public interface PaymentService {

    @GetMapping("/get/{id}")
    String get(@PathVariable("id") Long id);


    @GetMapping("/geterr/{id}")
    String geterr(@PathVariable("id") Long id);
}
