package com.dxn.config;

//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

import com.baomidou.mybatisplus.mapper.ISqlInjector;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author D.xn
 * date 2021/1/5
 */
@Configuration
public class MPConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

//    @Bean
//    public GlobalConfiguration globalConfiguration() {
//        GlobalConfiguration gc = new GlobalConfiguration();
//        gc.setLogicDeleteValue("1");
//        gc.setLogicNotDeleteValue("0");
//        gc.setSqlInjector(new LogicSqlInjector());
//
//        return gc;
//    }

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }


}
