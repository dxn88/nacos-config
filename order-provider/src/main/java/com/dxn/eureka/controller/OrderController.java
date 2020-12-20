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
public class OrderController {


    @Autowired
    Environment environment;

    @GetMapping("/config/name")
    public String getConfigName() {

        String port = environment.resolvePlaceholders("${server.port:}");

        System.out.println("port = " + port);
//
        String property = environment.getProperty("spring.application.name");

        System.out.println("property = " + property);

        return property;
    }
}
