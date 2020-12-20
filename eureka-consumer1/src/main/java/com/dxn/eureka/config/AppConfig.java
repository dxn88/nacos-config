package com.dxn.eureka.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


//    @Bean
//    public MyRibbonInterceptor myRibbonInterceptor(
//            LoadBalancerClient loadBalancerClient,
//            LoadBalancerRequestFactory requestFactory) {
//        return new MyRibbonInterceptor(loadBalancerClient, requestFactory);
//    }
//
//    @Bean
////    @ConditionalOnMissingBean
//    public RestTemplateCustomizer restTemplateCustomizer(
//            final List<LoadBalancerInterceptor> loadBalancerInterceptors) {
//        return restTemplate -> {
//            List<ClientHttpRequestInterceptor> list = new ArrayList<>(
//                    restTemplate.getInterceptors());
//            list.addAll(loadBalancerInterceptors);
//            restTemplate.setInterceptors(list);
//        };
//    }
}
