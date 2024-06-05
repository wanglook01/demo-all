package com.test;

import org.example.MockApplication;
import org.example.service.SkuService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * spring容器中使用
 */
@SpringBootTest(classes = MockApplication.class)
public class SkuSpringTest {

    @Resource
    private SkuService skuService;

    @BeforeAll
    public static void beforeAllAnno() {
        System.out.println("beforeAllAnno");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @Test
    public void test1() {
        System.out.println("-------test1--------");
        System.out.println(skuService.getById(7L));
    }


}
