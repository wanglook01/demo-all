package com.wanglook01.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    private static final String YYYYMMDD = "yyyyMMdd";

    public static Integer prevN(Integer date, Integer n) {
        LocalDate localDate = convert(date);
        LocalDate prev = localDate.minusDays(n);
        return Integer.parseInt(prev.format(DateTimeFormatter.ofPattern(YYYYMMDD)));
    }

    private static LocalDate convert(Integer i) {
        String str = i.toString();
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(4, 6));
        int day = Integer.parseInt(str.substring(6));
        return LocalDate.of(year, month, day);
    }

    public static Integer diff(Integer a, Integer b) {
        LocalDate localDateA = convert(a);
        LocalDate localDateB = convert(b);
        long until = localDateA.until(localDateB, ChronoUnit.DAYS);
        if (until < 0L) {
            return (int) MathUtil.mul(until, -1);
        } else {
            return (int) until;
        }
    }

    public static void main(String[] args) {
        Integer i = prevN(20240105, 1);
        Integer i2 = prevN(i, 1);
        Integer i3 = prevN(i2, 1);
        Integer i4 = prevN(i3, 1);
        Integer i5 = prevN(i4, 1);
        Integer i6 = prevN(i5, 1);
        Integer i7 = prevN(i6, 1);
        System.out.println(diff(i, i7));
        System.out.println(diff(i7, i));
    }
}
