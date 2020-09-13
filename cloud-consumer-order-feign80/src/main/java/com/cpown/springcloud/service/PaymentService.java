package com.cpown.springcloud.service;

import com.cpown.springcloud.dto.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-payment-service")
@Component
public interface PaymentService {

    @GetMapping("/get/{id}")
    CommonResult get(@PathVariable("id") Long id);
}
