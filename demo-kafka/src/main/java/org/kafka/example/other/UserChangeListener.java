package org.kafka.example.other;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserChangeListener {


    /*@KafkaListener(topics = TopicConst.USER_CONCURRENTLY_TOPIC, groupId = "myConsumerGroup-1",id = "id20",concurrency = "5")
    public void cclTopic(ConsumerRecord<String, String> record,
                         Acknowledgment ack,
                         @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("111线程=" + Thread.currentThread().getId() + ", 数据key=" + record.key() + ", 数据value=" + record.value());
        log.info("record");
        //手动提交offset
        ack.acknowledge();
    }

    @KafkaListener(id = "id21",
            topics = TopicConst.USER_CONCURRENTLY_TOPIC,
            topicPartitions = {@TopicPartition(topic = TopicConst.USER_CONCURRENTLY_TOPIC, partitions = {"0", "1"})},
            groupId = "myConsumerGroup-2",errorHandler = "myErrorHandler")
    public void cclTopic21(ConsumerRecord<String, String> record,
                           Acknowledgment ack,
                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("222线程=" + Thread.currentThread().getId() + ", 数据key=" + record.key() + ", 数据value=" + record.value());
        log.info("record");
        if (record.value().equals("age222")) {
            //throw new RuntimeException("遇到了问题");
        }
        //手动提交offset
        ack.acknowledge();
    }

    @KafkaListener(id = "id23",
            topics = TopicConst.USER_CONCURRENTLY_TOPIC,
            topicPartitions = {@TopicPartition(topic = TopicConst.USER_CONCURRENTLY_TOPIC, partitions = {"2", "3"})},
            groupId = "myConsumerGroup-2")
    public void cclTopic23(ConsumerRecord<String, String> record,
                           Acknowledgment ack,
                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("333线程=" + Thread.currentThread().getId() + ", 数据key=" + record.key() + ", 数据value=" + record.value());
        log.info("record");
        //手动提交offset
        ack.acknowledge();
    }

    @KafkaListener(topics = TopicConst.USER_CONCURRENTLY_TOPIC,
            groupId = "myConsumerGroup-1",
            id = "id20",
            concurrency = "5")
    public void cclTopic(ConsumerRecord<String, String> record,
                         Acknowledgment ack,
                         @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                         @Header(KafkaHeaders.RECEIVED_PARTITION) String partitionId) {
        log.info("111线程=" + Thread.currentThread().getId() + ", 数据key=" + record.key() + ", 数据value=" + record.value());
        //手动提交offset
        ack.acknowledge();
    }*/

}
