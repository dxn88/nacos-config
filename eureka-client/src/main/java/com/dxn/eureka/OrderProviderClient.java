package com.dxn.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dxn
 * date 2020/12/15
 * {@code OrderProviderClient}
 * {@link OrderProviderClient}
 * {@value }
 * {}
 */
@FeignClient(name = "order-provider", fallback = OrderProviderClientCallback.class, url = "http://localhost:8092")
public interface OrderProviderClient {
    @GetMapping("/config/name")
    String getConfigName();

    @GetMapping("/config/age")
    String getConfigAge();
}
