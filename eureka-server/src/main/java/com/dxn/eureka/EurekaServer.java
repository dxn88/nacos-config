package com.dxn.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
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
@EnableEurekaServer
public class EurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }
}
