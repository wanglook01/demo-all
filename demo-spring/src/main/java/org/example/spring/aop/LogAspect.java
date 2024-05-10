package org.example.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Before("execution(* org.example.spring.business.UserController.*(..))")
    public void before() {
        System.out.println("before");
    }
}
