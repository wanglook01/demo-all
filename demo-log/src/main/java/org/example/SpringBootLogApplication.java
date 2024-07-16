package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.BizException;
import org.example.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringBootLogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootLogApplication.class, args);
        log.info("args:{}", 111);
        //自定义异常不打印堆栈,对比
        DemoService demoService = context.getBean(DemoService.class);
        demoService.selfException();


        log.info("");
    }
}
