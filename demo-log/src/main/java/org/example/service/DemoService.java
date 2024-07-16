package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.BizException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class DemoService {

    public void selfException() {
        List<Integer> list = Arrays.asList(1, 2, 0);
        try {
            for (Integer integer : list) {
                System.out.println(20 / integer);
            }
        } catch (Exception e) {
            log.error("我们发现了异常", e);
        }
        try {
            for (Integer integer : list) {
                if (integer.equals(0)) {
                    throw new BizException("发现值为0");
                }
            }
        } catch (Exception e) {
            log.error("我们发现了自定义异常", e);
        }
    }
}
