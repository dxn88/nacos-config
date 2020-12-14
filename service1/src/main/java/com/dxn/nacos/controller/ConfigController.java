package com.dxn.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxn
 * date 2020/12/14
 */
@RestController
public class ConfigController {

    @Value("${spring.name}")
    private String name;

    @Value("${spring.age}")
    Integer age;

    @GetMapping("/config/name")
    public String getConfigName() {
        return name;
    }

    @GetMapping("/config/age")
    public Integer getConfigAge() {
        return age;
    }
}
