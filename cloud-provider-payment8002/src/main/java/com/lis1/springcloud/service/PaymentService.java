package com.lis1.springcloud.service;

import com.lis1.springcloud.entitis.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author lis1
 * @date 2022/5/9
 * @time 11:03
 */

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
