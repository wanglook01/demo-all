package org.example;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RocketMqWebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RocketMqWebApplication.class);
    }
}
