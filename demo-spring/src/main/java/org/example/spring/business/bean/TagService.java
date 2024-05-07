package org.example.spring.business.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Slf4j
public class TagService implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, InitializingBean ,DisposableBean{

    private ClassLoader classLoader;
    private BeanFactory beanFactory;
    private String beanName;

    public TagService() {
        log.warn("constructor");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.warn("setBeanClassLoader");
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.warn("setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        log.warn("setBeanName");
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("InitializingBean,afterPropertiesSet");
    }

    @PostConstruct
    public void pc() {
        log.warn("PostConstruct");
    }

    @PreDestroy
    public void pd() {
        log.warn("PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        log.warn("destroy,preDestroy之后执行");
    }


}
