package com.cpown.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * create by c-pown on
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain.class,args);
    }
}
