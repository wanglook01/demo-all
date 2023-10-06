package com.wanglook01;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protocol.PersonProtobuf;

public class ProtoTest {

    public static void main(String[] args) {
        //  序列化
        // 创建Person的Builder
        PersonProtobuf.Person.Builder builder = PersonProtobuf.Person.newBuilder();
        // 设置Person的属性
        builder.setSize(18);
        builder.setName("张三丰");
        builder.setDesc("我的家在东北松花江上啊");
        // 创建Person
        PersonProtobuf.Person zhangsanfeng = builder.build();
        // 序列化，byte[]可以被写到磁盘文件，或者通过网络发送出去。
        byte[] data = zhangsanfeng.toByteArray();
        System.out.println("serialization end.");

        // 反序列化，byte[]可以读文件或者读取网络数据构建。
        System.out.println("deserialization begin.");
        try {
            PersonProtobuf.Person person = PersonProtobuf.Person.parseFrom(data);
            System.out.println(person.getSize());
            System.out.println(person.getName());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        //如果我们使用json呢？
    }
}
