package com.lis1.springcloud.service.impl;

import com.lis1.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author lis1
 * @date 2022/7/26
 * @time 10:47
 */
@Component
public class PaymentHystrixFallback implements PaymentHystrixService {

    @Override
    public String paymentInfo_Succeed(Integer id) {
        return "PaymentHystrixFallback-paymentInfo_Succeed";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentHystrixFallback-paymentInfo_Timeout";
    }
}
