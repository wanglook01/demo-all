package org.kafka.example.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

public class CustomPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitionInfos = cluster.availablePartitionsForTopic(topic);
        //自定义分区逻辑
        if (key == null || StringUtils.isEmpty(key.toString())) {
            return 0;
        }
        int keyInt = Integer.parseInt(key.toString());
        if (keyInt >= partitionInfos.size()) {
            keyInt = partitionInfos.size() - 1;
        }
        return keyInt;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
