package com.dxn.eureka;

import com.dxn.eureka.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Nacos starter.
 *
 * @author nacos
 */
@SpringBootApplication
//@ServletComponentScan
//@EnableScheduling
//@EnableDiscoveryClient
//@EnableFeignClients
@RibbonClient(value = "eureka-provider", configuration = AppConfig.class)
public class EurekaConsumer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumer.class, args);
    }
}
