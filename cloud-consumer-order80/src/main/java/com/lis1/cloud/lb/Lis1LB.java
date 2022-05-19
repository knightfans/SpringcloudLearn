package com.lis1.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lis1的负载均衡轮询算法
 * @date 2022/5/19
 * @time 8:53
 */
@Component
public class Lis1LB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * @return
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            // int最大值不能超过2147483647
            next = current >= 2147483647 ? 0 : current + 1;
            //使用CAS进行循环判断
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("next:" + next);
        return next;
    }

    /**
     * @param serviceInstance 所有存活的服务列表
     * @return 服务列表中index指向的服务。
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstance) {
        int andIncrement = getAndIncrement();
        int index = andIncrement % serviceInstance.size();
        return serviceInstance.get(index);
    }
}
