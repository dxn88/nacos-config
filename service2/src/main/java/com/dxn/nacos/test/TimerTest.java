package com.dxn.nacos.test;


import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.TimerTask;

public class TimerTest {
    static String str = "HH:mm:ss";
    static SimpleDateFormat dateFormat = new SimpleDateFormat(str);

    public static void main(String[] args) {
        Class clazz = void.class;
        Class aClass = Override.class;
//        Class bClass =  ? extends TimerTest;
//        Type type = ? extends TimerTest;
    }
}

class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("该起床了");
        String now2 = TimerTest.dateFormat.format(System.currentTimeMillis());
        System.out.println(now2);
    }
}
