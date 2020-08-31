package com.cpown.springcloud.controller;

import com.cpown.springcloud.entities.Payment;
import com.cpown.springcloud.service.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentServiceImpl paymentService;

    @GetMapping("/get/{id}")
    public Payment get(@PathVariable("id") Long id){
        log.info(id+"");
        return paymentService.selectByPrimaryKey(id);
    }
}
