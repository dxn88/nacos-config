package com.dxn.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxn
 * date 2020/12/15
 */
@RestController
public class EurekaController {


    @Autowired
    Environment environment;

    @GetMapping("/config/name")
    public String getConfigName() {

        String serverAddr = environment.resolvePlaceholders("${server.port:}");

        System.out.println("serverAddr = " + serverAddr);

        String property = environment.getProperty("spring.application.name");

        System.out.println("property = " + property);

        return "wangjun";
    }
}
