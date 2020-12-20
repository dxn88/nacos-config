package com.dxn.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dxn
 * date 2020/12/15
 */

@FeignClient(name  = "order-provider")
public interface OrderProviderClient {
    @GetMapping("/config/name")
    String getConfigName();
}
