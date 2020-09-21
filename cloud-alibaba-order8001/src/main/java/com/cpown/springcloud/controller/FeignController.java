package com.cpown.springcloud.controller;

import com.cpown.springcloud.dto.CommonResult;
import com.cpown.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/get/{id}")
    public CommonResult getInfo(@PathVariable("id") Long id){
        return paymentService.get(id);
    }
}
