package com.lis1.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lis1
 * @date 2022/5/19
 * @time 13:47
 */
@Configuration
public class FeignConfig {

    //设置feign日志输出级别
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
