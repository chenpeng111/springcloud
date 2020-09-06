package com.cpown.springcloud.controller;

import com.cpown.springcloud.dto.CommonResult;
import com.cpown.springcloud.entities.Payment;
import com.cpown.springcloud.service.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        log.info("8002查询数据:"+id);
        Payment payment = paymentService.selectByPrimaryKey(id);
        if(null != payment){
            return new CommonResult("请求成功,serverPort:"+serverPort,0000,payment);
        }else {
            return new CommonResult("请求失败:serverPort"+serverPort,9999);
        }
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("8002新增数据"+payment);
        int insert = paymentService.insert(payment);
        log.info("8002新增数据结果："+insert);
        if(insert>0){
            return new CommonResult("插入数据成功:serverPort:"+serverPort,0000,payment);
        }else {
            return new CommonResult("插入数据失败:"+serverPort,9999);
        }
    }
}
