package com.dxn.eureka.controller;

import com.dxn.eureka.EurekaProviderClient;
import com.dxn.eureka.pojo.PersonVO;
import com.netflix.appinfo.MyDataCenterInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * @author dxn
 * date 2020/12/15
 */
@RestController
public class ConsumerController {

    @Resource
    EurekaProviderClient providerClient;

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/config/name")
    public String getConfigName() {
        System.out.println("NacosController.getConfigName");

        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://eureka-provider/config/name"
                , String.class);
//        String configName = providerClient.getConfigName();
//        System.out.println("configName = " + configName);
        return forEntity.getBody();
    }

    public static void main(String[] args) {
        Field[] declaredFields = MyDataCenterInfo.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField.getName());
        }
    }
}
