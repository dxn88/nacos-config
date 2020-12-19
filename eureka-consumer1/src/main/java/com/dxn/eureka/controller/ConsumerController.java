package com.dxn.eureka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/config/name")
    public String getConfigName() {

        final ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8092/config/name", String.class);
        System.out.println("forEntity.getBody() = " + forEntity.getBody());
        return forEntity.getBody();
    }
}
