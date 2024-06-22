package org.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.constant.TopicConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserChangeListener {



    @KafkaListener(topics = TopicConst.USER_CONCURRENTLY_TOPIC)
    public void cclTopic(ConsumerRecord<String, String> record,
                         Acknowledgment ack,
                         @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        System.out.println("线程=" + Thread.currentThread().getId() + ", 数据key=" + record.key() + ", 数据value=" + record.value());
        System.out.println(record);
        //手动提交offset
        ack.acknowledge();
    }

}
