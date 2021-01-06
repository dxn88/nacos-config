package com.dxn.config;

import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author D.xn
 * date 2021/1/6
 */
@Configuration
@Profile({"dev", "test"})
public class MPDevOrTestConfig {

    /**
     * 性能分析拦截器，用于显示每条 SQL 语句及其执行时间
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor pi = new PerformanceInterceptor();
        pi.setFormat(true);
        pi.setMaxTime(1000);

        return pi;
    }

    /**
     * 作用是分析 处理 DELETE UPDATE 语句， 防止小白或者恶意 delete update 全表操作！
     */
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor() {
        return new SqlExplainInterceptor();
    }
}
