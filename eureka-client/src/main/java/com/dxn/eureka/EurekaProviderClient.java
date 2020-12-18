package com.dxn.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dxn
 * date 2020/12/15
 */

@FeignClient(name  = "eureka-provider")
public interface EurekaProviderClient {
    @GetMapping("/config/name")
    String getConfigName();
}
