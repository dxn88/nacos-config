package com.dxn.nacos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dxn
 * date 2020/12/15
 */

@FeignClient(name  = "nacos-provider")
public interface NacosProviderClient {
    @GetMapping("/config/name")
    String getConfigName();
}
