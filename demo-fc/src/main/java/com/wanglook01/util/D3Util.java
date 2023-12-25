package com.wanglook01.util;

import java.util.ArrayList;
import java.util.List;

public class D3Util {

    public static List<String> getAll() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    result.add(i + "" + j + "" + k);
                }
            }
        }
        return result;
    }
}
