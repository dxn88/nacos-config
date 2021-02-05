package com.dxn.nacos.test;

import lombok.Data;

/**
 * @author D.xn
 * @since 2021/1/27
 */
@Data
public class Person {
    String name;


    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("dxn");

        Person p2 = new Person();
        p2.setName("dxn");

        if (p1.equals(p2)) {
            System.out.println("p2 = " + p2);
        }
    }
}
