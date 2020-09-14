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

    /**
     * 返回值正确的方法
     * @param id
     * @return
     */
    @GetMapping("/consumer/get/{id}")
    public String getInfo(@PathVariable("id") Long id){
        return paymentService.get(id);
    }

    /**
     * 有可能会异常的方法
     * @param id
     * @return
     */
    @GetMapping("/consumer/geterr/{id}")
    public String geterr(@PathVariable("id") Long id){
        return paymentService.geterr(id);
    }
}
