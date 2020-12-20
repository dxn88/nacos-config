package com.dxn.eureka.controller;


import com.dxn.eureka.EurekaProviderClient;
import com.dxn.eureka.OrderProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Resource
    EurekaProviderClient eurekaProviderClient;

    @Autowired
    OrderProviderClient orderProviderClient;
    @GetMapping("/config/name")
    public String getConfigName() {

//        final ResponseEntity<String> forEntity = restTemplate.getForEntity("http://eureka-provider/config/name", String.class);
//        final ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8092/config/name", String.class);
//        System.out.println("forEntity.getBody() = " + forEntity.getBody());
        final String configName = eurekaProviderClient.getConfigName();
        System.out.println("configName = " + configName);
        final String configName1 = orderProviderClient.getConfigName();
        System.out.println("configName1 = " + configName1);
        return configName + "_" +configName1;
    }
}
