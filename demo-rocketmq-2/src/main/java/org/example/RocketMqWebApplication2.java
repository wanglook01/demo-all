package org.example;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RocketMqWebApplication2 {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(RocketMqWebApplication2.class);
        DefaultMQProducer producer = context.getBean(DefaultMQProducer.class);
        for (int i = 0; i < 100; i++) {
            Message message = new Message("sku_change", "tag", "sku:" + i, ("message-body:" + i).getBytes());
            producer.send(message);
        }

    }
}
