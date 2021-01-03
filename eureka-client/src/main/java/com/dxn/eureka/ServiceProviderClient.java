package com.dxn.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dxn
 * date 2020/12/15
 * {@code OrderProviderClient}
 * {@link ServiceProviderClient}
 * {@value 5}
 * {}
 */
@FeignClient(name = "service-provider", url = "http://localhost:8092")
public interface ServiceProviderClient {
    @GetMapping("/config/name")
    String getConfigName();

    @GetMapping("/config/age")
    String getConfigAge();
}
