package com.cpown.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 客户端
 * create by c-pown on
 */@RestController
public class ConsumerController {
     @Resource
     private RestTemplate restTemplate;
     /**
      * 使用微服务名称进行调用
      */
     private static final String BASY_URL = "http://consul-provider-payment";

     @RequestMapping("/consumer/pay")
     public String order(){
         return restTemplate.getForObject(BASY_URL+"/consul/pay",String.class);
     }

}
