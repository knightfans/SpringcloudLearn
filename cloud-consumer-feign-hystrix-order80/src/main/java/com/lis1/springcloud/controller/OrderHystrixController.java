package com.lis1.springcloud.controller;

import com.lis1.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lis1
 * @date 2022/5/19
 * @time 17:04
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Succeed(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_Succeed(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        return result;
    }

    /**
     * 测试全局fallback方法
     * @return
     */
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/globalFallback")
    public String paymentGlobalFallback() {
        int i = 10 / 0;
        return "fallback方法必须和原方法返回同一类型";
    }

    /**
     * 客户端Fallback方法（测试发现：需和原方法形参一致 否则出现映射失败问题）
     *
     * @return
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "消费者80，对方支付系统繁忙请10秒后再试";
    }

    /**
     * 全局fallback方法，除个别指定映射fallback方法外全局通用
     * ps：fallback方法必须和原方法返回同一类型
     * @return
     */
    public String globalFallbackMethod() {
        return "Global异常处理";
    }
}

