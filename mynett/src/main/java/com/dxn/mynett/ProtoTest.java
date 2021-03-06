package com.dxn.mynett;

import com.dxn.mynett.pojo.StudentSerialize;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

public class ProtoTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        final StudentSerialize.Student dxn = StudentSerialize.Student.newBuilder()
                .setAge(35).setName("dxn").build();
        final int pensCount = dxn.getPensCount();
        System.out.println("pensCount = " + pensCount);
        System.out.println("dxn = " + dxn);
        final byte[] bytes = dxn.toByteString().toByteArray();
        final String s = Arrays.toString(bytes);
        System.out.println(s);

        final StudentSerialize.Student student = StudentSerialize.Student.parseFrom(bytes);
        System.out.println("student = " + student);
    }
}
