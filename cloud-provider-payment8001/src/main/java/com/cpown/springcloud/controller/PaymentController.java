package com.cpown.springcloud.controller;

import com.cpown.springcloud.dto.CommonResult;
import com.cpown.springcloud.entities.Payment;
import com.cpown.springcloud.service.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentServiceImpl paymentService;
    @Value("${server.port}")
    private String serverPort;
    /**
     * 配置此信息  可以对外暴露接口展示我们系统所包含的微服务信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        log.info("8001查询数据:"+id);
        Payment payment = paymentService.selectByPrimaryKey(id);
        if(null != payment){
            return new CommonResult("请求成功,serverPort:"+serverPort,0000,payment);
        }else {
            return new CommonResult("请求失败,serverPort:"+serverPort,9999);
        }
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("8001新增数据"+payment);
        int insert = paymentService.insert(payment);
        log.info("8001新增数据结果："+insert);
        if(insert>0){
            return new CommonResult("插入数据成功,serverPort:"+serverPort,0000,payment);
        }else {
            return new CommonResult("插入数据失败,serverPort:"+serverPort,9999);
        }
    }
    @RequestMapping("/payment/disxover")
    public Object discover(){
        /**
         * 查看当前所有的微服务
         */
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service*******"+service);
        }

        /**
         * 获取对应微服务id 的所有实例
         * 也就是我们的 8001  8002
         */
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info("---"+instance.getServiceId()+"***"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

}
