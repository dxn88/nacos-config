package com.dxn.eureka.config;


import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class MyRibbonInterceptor extends LoadBalancerInterceptor {


    public MyRibbonInterceptor(LoadBalancerClient loadBalancer, LoadBalancerRequestFactory requestFactory) {
        super(loadBalancer, requestFactory);
    }

    public MyRibbonInterceptor(LoadBalancerClient loadBalancer) {
        super(loadBalancer);
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        final String path = request.getURI().getPath();
        System.out.println("path = " + path);

        return super.intercept(request, body, execution);
    }
}
