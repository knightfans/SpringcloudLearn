package com.lis1.cloud;

import com.lis1.rule.Ru1e;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lis1
 * @date 2022/5/9
 * @time 14:54
 */
@EnableEurekaClient
@SpringBootApplication
// @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = Ru1e.class)  //使用Ribbon给定的负载均衡规则
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
