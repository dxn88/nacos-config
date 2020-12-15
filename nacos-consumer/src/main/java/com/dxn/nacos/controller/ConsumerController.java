package com.dxn.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxn
 * date 2020/12/15
 */
@RestController
public class ConsumerController {

//    NacosProviderClient nacosProviderClient;

    @GetMapping("/config/name")
    public String getConfigName() {
        System.out.println("NacosController.getConfigName");
//        return nacosProviderClient.getConfigName();
        return "1";
    }
}
