package com.cpown.springcloud.controller;

import com.cpown.springcloud.dto.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    //aasss feature-cp
    //feature-cp-1
    //feature-cp 提交到指定远程分支


    @GetMapping("/getInfo/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        log.info("9001查询数据:"+id);
        return new CommonResult("请求成功,serverPort:"+serverPort,0000, UUID.randomUUID());
    }

}
