package com.dxn.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxn
 * date 2020/12/14
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${spring.name}")
    private String name;

    @Value("${spring.age}")
    Integer age;


    @Autowired
    ConfigurableApplicationContext configurableApplicationContext;

    @GetMapping("/config/name")
    public String getConfigName() {
        return name;
    }

    @GetMapping("/config/age")
    public Integer getConfigAge() {
        return age;
    }

    @GetMapping("/config/dynamic")
    public String  getConfigDynamic() {
        return configurableApplicationContext.getEnvironment().getProperty("spring.name");
    }

    @GetMapping("/config/dev")
    public String  getConfigDev() {
        return configurableApplicationContext.getEnvironment().getProperty("springdev.name");
    }
}
