package com.dxn.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

public class TestRegister {

    public static void main(String[] args) throws NacosException {
        final NamingService namingService = NamingFactory.createNamingService("192.168.1.7:8848");

        String serviceName = "testInstance";

        Instance instance = new Instance();

        instance.setIp("172.0.0.9");
        instance.setPort(8811);
        instance.setClusterName("DEFAULT");
        instance.setEphemeral(false);
        namingService.registerInstance(serviceName, instance);
    }
}
