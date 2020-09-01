package com.cpown.springcoloud.controller;

import com.cpown.springcloud.dto.CommonResult;
import com.cpown.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 订单调用controller
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    RestTemplate restTemplate;
    private static  final  String baseUrl = "http://localhost:8001";

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") String id){
        return restTemplate.getForObject(baseUrl+"/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(baseUrl+"/create",payment,CommonResult.class);
    }
}
