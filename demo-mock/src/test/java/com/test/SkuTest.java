package com.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 简单的测试
 */
public class SkuTest {

    @BeforeAll
    public static void beforeAllAnno(){
        System.out.println("beforeAllAnno");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }

    @Test
    public void test1(){
        System.out.println("-------test1--------");
    }

    @Test
    public void test2(){
        System.out.println("-------test2--------");
    }




}
