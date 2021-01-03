package com.dxn.eureka.controller;


import com.alibaba.csp.sentinel.CtSph;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.Sph;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.init.InitExecutor;
import com.alibaba.csp.sentinel.node.NodeBuilder;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.dxn.eureka.OrderProviderClient;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Resource
    OrderProviderClient eurekaProviderClient;
//
//    @Autowired
//    OrderProviderClient orderProviderClient;

    @GetMapping("/config/name")
    public String getConfigName() throws MalformedURLException, URISyntaxException {

        try (final Entry hello = SphU.entry("hello")) {

            return eurekaProviderClient.getConfigName();
        } catch (BlockException e) {
            e.printStackTrace();
        }

        return "系统繁忙，请稍后重试";
    }


//    @PostConstruct
//    public void initRules() {
//        // 1 创建限流规则集合
//        List<FlowRule> flowRules = new ArrayList<>();
//        // 2 创建限流
//        FlowRule flowRule = new FlowRule();
//        // 3 定义资源，规则对哪个资源生效
//        flowRule.setResource("hello");
//        // 定义限流类型
//        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        // 每秒可以通过的请求为 2
//        flowRule.setCount(2);
//
//        flowRules.add(flowRule);
//
//        FlowRuleManager.loadRules(flowRules);
//
//    }


    static class GetConfigNameCommand extends HystrixCommand<String> {

        private String name;

        protected GetConfigNameCommand(HystrixCommandGroupKey group) {
            super(group);
        }

        @Override
        protected String run() throws Exception {
            return null;
        }

        @Override
        protected String getFallback() {
            return null;
        }
    }


}
