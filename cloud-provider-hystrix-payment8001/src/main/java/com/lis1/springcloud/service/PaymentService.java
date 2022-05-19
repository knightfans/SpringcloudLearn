package com.lis1.springcloud.service;

import org.springframework.stereotype.Service;

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
     *
     * @param id
     * @return
     */
    public String paymentInfo_Timeout(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "   paymentInfo_Timeout:  " + id + "，耗时: " + time + "秒";
    }
}

