package com.dxn.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dxn
 * date 2020/12/15
 */

@FeignClient(name = "eureka-provider")
public interface EurekaProviderClient {
    @GetMapping("${path.url}")
    String getConfigName();

    @GetMapping("/config/age")
    <T> void getConfigAge(Person<T> tPerson);

    default void defaultm() {
        System.out.println("true = " + true);
    }

    class Person<T> {
    }
}
