package com.cpown.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建新的ruleBean
 * create by c-pown on
 */
@Configuration
public class MyRuleConfig {
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
