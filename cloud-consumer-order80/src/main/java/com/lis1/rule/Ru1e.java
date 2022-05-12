package com.lis1.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lis1
 * @date 2022/5/12
 * @time 15:15
 * Ribbon负载均衡规则类
 */
@Configuration
public class Ru1e {

    @Bean
    public IRule randomRu1e() {
        //使用随机负载均衡规则
        return new RandomRule();
    }
}
