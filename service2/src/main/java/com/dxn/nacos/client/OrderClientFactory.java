package com.dxn.nacos.client;

/**
 * @author Dai.xn
 * @since 2021/2/5
 */
public interface OrderClientFactory {

    <C extends OrderClient<?, ?>> C getOderClient();
}
