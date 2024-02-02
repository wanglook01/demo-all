package com.wanglook01.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdUtil {

    public static Long getId() {
        // 获取当前日期时间
        LocalDateTime now = LocalDateTime.now();

        // 创建DateTimeFormatter对象，指定日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        // 使用DateTimeFormatter对象格式化LocalDateTime对象，得到当前日期时间字符串
        return Long.parseLong(now.format(formatter));

    }
}
