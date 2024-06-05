package com.test;

import org.example.MockApplication;
import org.example.dto.SkuPo;
import org.example.repo.SkuMapper;
import org.example.service.SkuService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

/**
 * spring容器中使用
 */
@SpringBootTest(classes = MockApplication.class)
public class SkuSpringMockTest2 {

    @Resource
    private SkuService skuService;

    @MockBean
    private SkuMapper skuMapper;

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
    public void test2() {
        System.out.println("-------test2--------");
        Mockito.when(skuMapper.selectById(7L)).thenReturn(new SkuPo());
        SkuPo byId = skuService.getById(7L);
        Assertions.assertNotNull(byId);
        System.out.println(byId);
    }


}
