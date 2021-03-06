package com.cpown.springcloud;

import com.cpown.myrule.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * create by c-pown on
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "consul-provider-payment",configuration = MyRuleConfig.class)
public class ConsulOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain.class,args);
    }
}
