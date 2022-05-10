package com.lis1.springcloud.service.impl;

import com.lis1.springcloud.dao.PaymentDao;
import com.lis1.springcloud.entitis.Payment;
import com.lis1.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lis1
 * @date 2022/5/9
 * @time 11:04
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    public PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
