package com.dxn.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dxn
 * date 2020/12/15
 */
@RestController
public class NacosController {


    @Autowired
    Environment environment;

    @GetMapping("/config/name")
    public String getConfigName() {

        String serverAddr = environment
                .resolvePlaceholders("${server.port:}");
        System.out.println("serverAddr = " + serverAddr);

        return "wangjun";
    }
}
