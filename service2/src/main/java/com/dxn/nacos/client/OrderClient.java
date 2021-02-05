package com.dxn.nacos.client;

/**
 * @author Dai.xn
 * @since 2021/2/5
 */
public interface OrderClient<T extends OrderBaseParam, D> {

    <R extends Result<D>> R createOrder(T paramObject);
}
