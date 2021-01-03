package com.dxn.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dxn
 * date 2020/12/15
 * {@code OrderProviderClient}
 * {@link OrderProviderClientCallback}
 * {@value }
 * {}
 */
@Component
public class OrderProviderClientCallback implements OrderProviderClient {
    @Override
    public String getConfigName() {
        return "callback_name";
    }

    @Override
    public String getConfigAge() {
        return "callback_age";
    }
}
