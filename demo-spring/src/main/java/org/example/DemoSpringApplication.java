package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringApplication.class);
        System.out.println("Hello world web!");
    }
}