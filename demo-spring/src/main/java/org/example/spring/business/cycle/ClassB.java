package org.example.spring.business.cycle;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ClassB {

    @Getter
    @Setter
    private String name;

    @Resource
    private ClassA classA;

    public ClassB() {
    }

    public ClassB(String name) {
        this.name = name;
    }

    public void test(){

    }
}
