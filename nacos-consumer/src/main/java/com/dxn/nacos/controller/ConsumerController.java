package com.dxn.nacos.controller;

import com.dxn.nacos.NacosProviderClient;
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
    NacosProviderClient nacosProviderClient;

    @GetMapping("/config/name")
    public String getConfigName() {
        System.out.println("NacosController.getConfigName");
        String configName = nacosProviderClient.getConfigName();
        System.out.println("configName = " + configName);
        return configName;
    }
}
