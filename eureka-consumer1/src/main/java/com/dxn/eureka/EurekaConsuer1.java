package com.dxn.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Nacos starter.
 *
 * @author nacos
 */
@SpringBootApplication
//@ServletComponentScan
//@EnableScheduling
//@EnableDiscoveryClient
@EnableFeignClients
public class EurekaConsuer1 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsuer1.class, args);
    }
}
