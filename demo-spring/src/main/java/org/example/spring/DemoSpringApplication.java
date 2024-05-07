package org.example.spring;

import org.example.extra.ExtraService;
import org.example.extra.ProxyService;
import org.example.extra.SearchService;
import org.example.spring.anno.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {ExtraService.class,
        CustomImportBeanDefinitionRegistrar.class,
        BusinessProperties.class,
        CustomImportSelector.class,
        CustomDeferredImportSelector.class,
        CustomGroupDeferredImportSelector.class})
//@EnableConfigurationProperties(value = {CustomBusinessProperties.class})
public class DemoSpringApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoSpringApplication.class);
        System.out.println("Hello world web!");
        //
        BusinessProperties bean = context.getBean(BusinessProperties.class);
        System.out.println(bean.getType());
        //
        SearchProperties sp = context.getBean(SearchProperties.class);
        System.out.println(sp);
        //
        ExtraService extraService = context.getBean(ExtraService.class);
        System.out.println(extraService.getAge());
        //
        ProxyService proxyService = context.getBean(ProxyService.class);
        System.out.println(proxyService.getHouseMessage());
        //
        SearchService searchService = context.getBean(SearchService.class);
        System.out.println(searchService.getSearchUrl());
    }
}