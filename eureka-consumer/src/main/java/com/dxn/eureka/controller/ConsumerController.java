package com.dxn.eureka.controller;

import com.dxn.eureka.EurekaProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dxn
 * date 2020/12/15
 */
@RestController
public class ConsumerController {

    @Resource
    EurekaProviderClient providerClient;

    @GetMapping("/config/name")
    public String getConfigName() {
        System.out.println("NacosController.getConfigName");

        return providerClient.getConfigName();
    }
}
