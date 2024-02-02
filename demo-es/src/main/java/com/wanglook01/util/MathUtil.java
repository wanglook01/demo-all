package com.wanglook01.util;

import java.util.Random;

public class MathUtil {


    private static final Random RANDOM = new Random();

    /**
     * 生成100到999之间（包括100和999）的随机整数
     *
     * @return 随机整数
     */
    public static int generateRandomBetween100And999() {
        return RANDOM.nextInt(900) + 100; //nextInt(upperBound - lowerBound + 1) + lowerBound
    }

    public static int generateRandomBetween0And14() {
        return RANDOM.nextInt(15);
    }
}
