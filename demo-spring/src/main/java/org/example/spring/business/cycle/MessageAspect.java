package org.example.spring.business.cycle;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MessageAspect {

    @Before("execution(* org.example.spring.business.cycle.*.*())")
    public void before() {
        System.out.println("before");
    }
}
