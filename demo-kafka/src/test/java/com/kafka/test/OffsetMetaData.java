package com.kafka.test;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListConsumerGroupOffsetsResult;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Map;
import java.util.Properties;

public class OffsetMetaData {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9094");
        AdminClient admin = AdminClient.create(props);

        String groupId = "myConsumerGroup-1";
        ListConsumerGroupOffsetsResult offsetsResult = admin.listConsumerGroupOffsets(groupId);

        System.out.println("Consumer Group Offsets for group " + groupId);

        for (Map.Entry<TopicPartition, OffsetAndMetadata> entry : offsetsResult.partitionsToOffsetAndMetadata().get().entrySet()) {
            System.out.printf("Topic: %s, Partition: %d, Offset: %d%n",
                    entry.getKey().topic(), entry.getKey().partition(), entry.getValue().offset());
        }
        admin.close();
    }
}
