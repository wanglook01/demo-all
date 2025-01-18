package org.kafka.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.kafka.example.constant.TopicConst;
import org.kafka.example.dto.SkuPriceChangeDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.utils.example.JsonUtil;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ConsumerListener {

    @KafkaListener(id = "skuPriceChangeListener",
            topics = {TopicConst.SKU_PRICE_CHANGE_TOPIC},
            groupId = "skuPriceChangeGroup",
            clientIdPrefix = "client",
            concurrency = "10",
            autoStartup = "true",
            splitIterables = true,
            batch = "true")
    public void skuPriceChangeConsume(List<ConsumerRecord<String, String>> recordList,
                                      Acknowledgment ack) {
        List<String> priceChangeList = recordList.stream().map(x -> JsonUtil.readValue(x.value(), SkuPriceChangeDTO.class)).map(x -> x.getFromPrice() + "->" + x.getToPrice()).collect(Collectors.toList());
        log.info("111线程:{}, priceChangeList:{}", Thread.currentThread().getId(), priceChangeList);
        log.info("recordList：{}", recordList.size());
        ack.acknowledge();
    }


}
