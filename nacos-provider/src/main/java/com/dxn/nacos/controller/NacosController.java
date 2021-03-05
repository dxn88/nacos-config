package com.dxn.nacos.controller;

import com.dxn.nacos.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
    User user;

    @Autowired
    Environment environment;

    @GetMapping("/config/name")
    public String getConfigName() {

        String serverAddr = environment.resolvePlaceholders("${user.name}");
        System.err.println("serverAddr = " + serverAddr);

        String property = environment.getProperty("user.age");
        System.err.println("property = " + property);

        String uId = environment.getProperty("user.id");
        System.err.println("property = " + uId);
        return "wangjun";
    }


    @GetMapping("/user")
    public String user() {

        return user.toString();
    }
}
