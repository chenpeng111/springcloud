package com.cpown.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
@EnableEurekaClient
public class HystrixPaymentServiceMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentServiceMain8001.class,args);
    }
}
