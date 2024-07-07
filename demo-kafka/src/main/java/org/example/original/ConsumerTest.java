package org.example.original;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumerTest {


    public static void main(String[] args) {
        // 创建Kafka消费者的配置属性
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // Kafka集群的地址，如果是多台服务器则用逗号分隔
        props.put("group.id", "test-group"); // 消费者组ID，相同组内的消费者会进行消息的均衡分配
        props.put("enable.auto.commit", "true"); // 是否自动提交消费偏移量
        props.put("auto.commit.interval.ms", "1000"); // 自动提交的时间间隔
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // 消费者key的反序列化器
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // 消费者value的反序列化器

        // 使用配置创建Kafka消费者实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // 订阅主题
        consumer.subscribe(Collections.singletonList("test-topic")); // 替换为你要订阅的主题名称

        try {
            while (true) {
                // 拉取消息，等待时间为100毫秒
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

                // 遍历接收到的消息记录
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        } finally {
            // 关闭消费者
            consumer.close();
        }
    }
}
