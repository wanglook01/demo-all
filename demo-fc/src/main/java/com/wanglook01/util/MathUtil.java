package com.wanglook01.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil {

    /**
     * 默认除法运算精度: 2位小数
     */
    public static final int DEFAULT_SCALE = 2;

    /**
     * 除法运算精度: 4位小数
     */
    public static final int SCALE_FOUR = 4;


    /**
     * 加法: a + b
     */
    public static double add(double a, double b) {
        BigDecimal aa = new BigDecimal(Double.toString(a));
        BigDecimal bb = new BigDecimal(Double.toString(b));
        return aa.add(bb).doubleValue();
    }

    /**
     * 加法: a + b + c ...
     */
    public static double add(double a, double b, double... ds) {
        double result = add(a, b);
        for (double item : ds) {
            result = add(result, item);
        }
        return result;
    }

    /**
     * 加法: a+b
     */
    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    /**
     * 加法: a+b
     */
    public static BigDecimal add(BigDecimal a, BigDecimal b, BigDecimal... ds) {
        BigDecimal result = a.add(b);
        for (BigDecimal item : ds) {
            result = result.add(item);
        }
        return result;
    }


    /**
     * 减法: a-b
     */
    public static double sub(double a, double b) {
        BigDecimal ba = new BigDecimal(Double.toString(a));
        BigDecimal bb = new BigDecimal(Double.toString(b));
        return ba.subtract(bb).doubleValue();
    }

    /**
     * 减法: a-b-c ...
     */
    public static double sub(double a, double b, double... ds) {
        double result = sub(a, b);
        for (double item : ds) {
            result = sub(result, item);
        }
        return result;
    }

    /**
     * 减法
     */
    public static BigDecimal sub(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    /**
     * 减法: a-b
     */
    public static BigDecimal sub(BigDecimal a, BigDecimal b, BigDecimal... ds) {
        BigDecimal result = a.subtract(b);
        for (BigDecimal item : ds) {
            result = result.subtract(item);
        }
        return result;
    }


    /**
     * 除法： a/b 保留两位小数
     */
    public static double div2(double a, double b) {
        return div(a, b, DEFAULT_SCALE);
    }

    /**
     * 除法： a/b 保留4位小数
     */
    public static double div4(double a, double b) {
        return div(a, b, SCALE_FOUR);
    }

    /**
     * 除法，保留scale位小数，当scale小于0的时候，保留两位
     */
    public static double div(double a, double b, int scale) {
        if (scale < 0) {
            scale = DEFAULT_SCALE;
        }
        BigDecimal ba = new BigDecimal(Double.toString(a));
        BigDecimal bb = new BigDecimal(Double.toString(b));
        return ba.divide(bb, scale, RoundingMode.HALF_UP).doubleValue();
    }


    /**
     * 除法: a/b 保留2位小数
     */
    public static BigDecimal div2(BigDecimal a, BigDecimal b) {
        return div(a, b, DEFAULT_SCALE);
    }

    /**
     * 除法: a/b 保留4位小数
     */
    public static BigDecimal div4(BigDecimal a, BigDecimal b) {
        return div(a, b, SCALE_FOUR);
    }

    /**
     * 除法，保留scale位小数，当scale小于0的时候，保留两位
     */
    public static BigDecimal div(BigDecimal a, BigDecimal b, int scale) {
        if (scale < 0) {
            scale = DEFAULT_SCALE;
        }
        return a.divide(b, scale, RoundingMode.HALF_UP);
    }


    /**
     * 获取百分比
     */
    public static double percent(double value) {
        return mul2(value, 100);
    }


    /**
     * 乘法: a * b
     */
    public static double mul(double a, double b) {
        BigDecimal ba = new BigDecimal(Double.toString(a));
        BigDecimal bb = new BigDecimal(Double.toString(b));
        return ba.multiply(bb).doubleValue();
    }

    /**
     * 乘法: a * b, 保留2位小数
     */
    public static double mul2(double a, double b) {
        return mul(a, b, DEFAULT_SCALE);
    }

    /**
     * 乘法: a * b, 保留4位小数
     */
    public static double mul4(double a, double b) {
        return mul(a, b, SCALE_FOUR);
    }

    /**
     * 乘法: a * b, 保留scale位小数，当scale小于0的时候，保留两位
     */
    public static double mul(double a, double b, Integer scale) {
        if (scale < 0) {
            scale = DEFAULT_SCALE;
        }
        BigDecimal aa = new BigDecimal(Double.toString(a));
        BigDecimal bb = new BigDecimal(Double.toString(b));
        return aa.multiply(bb).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 乘法: a * b
     */
    public static BigDecimal mul(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    /**
     * 乘法: a * b, 保留两位小数
     */
    public static BigDecimal mul2(BigDecimal a, BigDecimal b) {
        return mul(a, b, DEFAULT_SCALE);
    }

    /**
     * 乘法: a * b, 保留4位小数
     */
    public static BigDecimal mul4(BigDecimal a, BigDecimal b) {
        return mul(a, b, SCALE_FOUR);
    }

    /**
     * 乘法: a * b, 保留scale位小数，当scale小于0的时候，保留两位
     */
    public static BigDecimal mul(BigDecimal a, BigDecimal b, Integer scale) {
        if (scale < 0) {
            scale = DEFAULT_SCALE;
        }
        return a.multiply(b).setScale(scale, RoundingMode.HALF_UP);
    }


}
