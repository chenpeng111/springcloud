package com.cpown.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

/**
 * 服务接口提供类
 */
@Service
public class PayService {

    public String getInfo(){
        return "服务端口成功:"+ UUID.randomUUID();
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后跳闸
    })
    public String getInfoError(@PathVariable("id") Long id){
        if(id<0){
            throw new RuntimeException("服务调用失败 ：id 不可以为负数");
        }
        return "服务端口成功:"+ UUID.randomUUID();    }

    /**
     * 服务降级回调方法
     * @param id
     * @return
     */
    public String fallback(@PathVariable("id") Long id){
        return "id不可以为负数:"+id;
    }
}
