package com.lis1.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author lis1
 * @date 2022/5/19
 * @time 8:45
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstance);
}
