package com.dxn.nacos.bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 发布事件 {@link RefreshScopeRefreshedEvent} {@link EnvironmentChangeEvent}
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "user")
public class User {
//    @Value("${user.id:}")
    Integer id;
//    @Value("${user.name:}")
    String name;
//    @Value("${user.age:}")
    Integer age;
}





