package org.example.calculate;

public class RedisCalculate {

    public static void main(String[] args) {
        long string = getString(10000L, 8L, 10L);
        System.out.println(string / 1024);
    }

    public static long getSds(long num, long len) {
        if (len <= Math.pow(2, 5) - 1) {
            //0-31，使用的是flags+buf,sdshdr5
            return num * (1 + len);
        } else if (len <= Math.pow(2, 8) - 1) {
            //31以上，存储的是sdshdr8,字节数为：0-255
            return num * (1 + 1 + 1 + len);
        } else if (len <= Math.pow(2, 16) - 1) {
            //31以上，存储的是sdshdr16，字节数为0-65535
            return num * (2 + 2 + 1 + len);
        } else if (len <= Math.pow(2, 32) - 1) {
            //31以上，存储的是sdshdr32
            return num * (4 + 4 + 1 + len);
        } else if (len <= Math.pow(2, 64) - 1) {
            //31以上，存储的是sdshdr64
            return num * (8 + 8 + 1 + len);
        }
        return 0L;
    }

    public static long getString(long key_num, long key_len, long value_len) {
        long sdsKey = getSds(key_num, key_len);
        long sdsValue = getSds(key_num, value_len);
        return sdsKey + sdsValue;
    }


}
