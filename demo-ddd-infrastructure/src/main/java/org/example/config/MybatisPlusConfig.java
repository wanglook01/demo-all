package org.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = {"org.example.group.mapper", "org.example.log.mapper"})
public class MybatisPlusConfig {

}
