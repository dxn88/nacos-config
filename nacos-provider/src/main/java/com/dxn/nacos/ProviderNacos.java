package com.dxn.nacos;/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.dxn.nacos.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Nacos starter.
 *
 * @author nacos
 */
@SpringBootApplication
//@ServletComponentScan
//@EnableScheduling
@EnableDiscoveryClient
@EnableFeignClients
public class ProviderNacos {
    
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(ProviderNacos.class, args);
        final User bean = run.getBean("scopedTarget.user",User.class);
        System.out.println("bean = " + bean);
        final User bean1 = run.getBean("user",User.class);
        System.out.println("bean1 = " + bean1);

    }
}
