package com.wanglook01.util;

import java.util.Random;

public class RandomUtil {

    public static Integer randomInteger() {
        return new Random().nextInt(10000);
    }

    public static Long randomLong() {
        int i = new Random().nextInt(10000);
        return (long) i;
    }

    public static String randomStr(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
