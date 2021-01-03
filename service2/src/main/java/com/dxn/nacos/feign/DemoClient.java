package com.dxn.nacos.feign;

import feign.RequestLine;

public interface DemoClient {
    @RequestLine("GET /config/name")
    String getDemo1();

}