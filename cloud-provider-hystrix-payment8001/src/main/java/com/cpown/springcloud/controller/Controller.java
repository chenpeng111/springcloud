package com.cpown.springcloud.controller;

import com.cpown.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 接口服务访问
 */
@RestController
public class Controller {

    @Value("${server.port}")
    private String serverport;
    @Resource
    PayService payService;

    @RequestMapping("/get/{id}")
    public String getInfo(@PathVariable("id") Long id){
       return payService.getInfo();
    }


    @RequestMapping("/geterr/{id}")
    public String getInfo_error(@PathVariable("id") Long id){
        return payService.getInfoError(id);
    }

}
