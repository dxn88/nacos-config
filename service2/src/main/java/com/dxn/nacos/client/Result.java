package com.dxn.nacos.client;

import lombok.Data;

/**
 * @author Dai.xn
 * @since 2021/2/5
 */
@Data
public class Result<T> {
    T data;

    String msg;

    Integer code;
}
