package com.lis1.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lis1
 * @date 2022/5/9
 * @time 15:16
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  //使用@LoadBalanced注解赋予RestTemplate负载均衡能力（默认轮询）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
