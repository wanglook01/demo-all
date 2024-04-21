package org.example;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DemoDddWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDddWebApplication.class);
        System.out.println("Hello world web!");
    }
}
