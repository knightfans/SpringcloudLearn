package com.lis1.springcloud.controller;

import com.lis1.springcloud.entitis.CommonResult;
import com.lis1.springcloud.entitis.Payment;
import com.lis1.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lis1
 * @date 2022/5/19
 * @time 11:23
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentTimeout(){
        //openfeign-ribbon，客户端一般默认等待1秒
        return paymentFeignService.paymentFeignTimeOut();
    }
}
