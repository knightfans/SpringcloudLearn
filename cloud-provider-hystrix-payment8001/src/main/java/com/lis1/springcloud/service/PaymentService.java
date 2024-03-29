package com.lis1.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author lis1
 * @date 2022/5/19
 * @time 15:41
 */
@Service
public class PaymentService {
    /**
     * 正常访问必定成功测试
     *
     * @param id
     * @return
     */
    public String paymentInfo_Succeed(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "   paymentInfo_succeed:  " + id;
    }

    /**
     * 正常访问必定失败测试
     * 运行时异常和超时都由fallbackMethod指定的方法(paymentInfo_TimeoutHandle)处理
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "7000")})
    public String paymentInfo_Timeout(Integer id) {
//        int age = 10/0;
        int time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "   paymentInfo_Timeout:  " + id + "，耗时: " + time + "秒";
    }

    /**
     * 测试服务端fallback处理
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeoutHandle(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "   系统繁忙，请稍后再试  " + id + "，fallback处理 ";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期(时间范围)
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10")//失败率达到多少后熔断(跳闸)
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 1) {
            throw new RuntimeException("id不能小于1");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能小于1，请检查id：" + id;
    }
}

