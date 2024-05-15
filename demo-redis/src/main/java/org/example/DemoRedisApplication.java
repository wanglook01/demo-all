package org.example;

import org.example.dto.GetSkuListResDTO;
import org.example.service.RedisCacheService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoRedisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoRedisApplication.class);
        RedisCacheService redisCacheService = context.getBean(RedisCacheService.class);
        //redisCacheService.save();
        redisCacheService.saveSku();
        //redisCacheService.saveSkuProto();
        System.out.println("success");
        GetSkuListResDTO getSkuListResDTO = redisCacheService.get();
        System.out.println(getSkuListResDTO);
    }
}
