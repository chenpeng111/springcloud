package com.cpown.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * consul服务controller
 * create by c-pown on
 */
@RestController
public class ConsulController {

    @Value("${server.port}")
    private String port;

    /**
     * 只有一个服务
     */
    @RequestMapping("/consul/pay")
    public String payservice(){
        return "当前服务端口是"+port+",调用服务成功";
    }
}
