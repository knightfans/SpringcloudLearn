package com.lis1.springcloud.dao;

import com.lis1.springcloud.entitis.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lis1
 * @date 2022/5/9
 * @time 10:46
 */

@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
