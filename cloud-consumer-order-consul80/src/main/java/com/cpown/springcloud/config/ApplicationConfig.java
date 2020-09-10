package com.cpown.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 创建RestTemplate Bean
 * create by c-pown on
 */
@Configuration
public class ApplicationConfig {
     @Bean
     @LoadBalanced
     public RestTemplate restTemplate(){
         return new RestTemplate();
     }
}
