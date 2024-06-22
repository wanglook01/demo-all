package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        // 创建一个 ObjectMapper 实例
        ObjectMapper mapper = new ObjectMapper();

        // 创建一个 JSON 对象（示例）
        //Object jsonObject = new Object(); // 假设这是一个 JSON 对象
        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("name", "wang");

        // 将 JSON 对象转换为字节数组
        byte[] jsonBytes = mapper.writeValueAsBytes(jsonObject);

        // 打印字节数组内容（转换为字符串显示）
        System.out.println("JSON as byte[]: " + new String(jsonBytes, StandardCharsets.UTF_8));


    }
}