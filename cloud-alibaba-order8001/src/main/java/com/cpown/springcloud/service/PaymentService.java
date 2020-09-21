package com.cpown.springcloud.service;

import com.cpown.springcloud.dto.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider")
@Component
public interface PaymentService {

    @GetMapping("/getInfo/{id}")
    CommonResult get(@PathVariable("id") Long id);
}
