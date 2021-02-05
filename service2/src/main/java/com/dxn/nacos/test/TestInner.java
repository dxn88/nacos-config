package com.dxn.nacos.test;

/**
 * @author D.xn
 * @since 2021/1/25
 */
public class TestInner {
    String aaa = "dxn";

    public static void main(String[] args) {
        TestInner testInner = new TestInner();
        testInner.print();
    }

    public void print(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa = " + TestInner.this.aaa);
            }
        });
        thread.start();
    }
}
