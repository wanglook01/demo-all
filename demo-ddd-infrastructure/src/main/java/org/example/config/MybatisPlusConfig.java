package org.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.example.group.mapper")
public class MybatisPlusConfig {

}
