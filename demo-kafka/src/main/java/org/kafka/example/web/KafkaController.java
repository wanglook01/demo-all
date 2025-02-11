package org.kafka.example.web;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.kafka.example.constant.TopicConst;
import org.kafka.example.dto.SkuPriceChangeDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.utils.example.JsonUtil;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * http://127.0.0.1:8888/kafka/send/ssu1239stock100
 */
@Slf4j
@Controller
@RequestMapping("/kafka")
@ResponseBody
public class KafkaController {

    public static BigDecimal from = new BigDecimal("1");

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Resource(name = "customPartitionerProducer")
    private Producer<String, String> customPartitionerProducer;

    @Resource(name = "customTrxProducer")
    private Producer<String, String> customTrxProducer;


    @RequestMapping("/send")
    public String sendMessage() throws Exception {
        Long skuId = 1396L;
        for (int i = 0; i < 100; i++) {
            BigDecimal toPrice = from.add(new BigDecimal(1));
            SkuPriceChangeDTO skuPriceChangeDTO = new SkuPriceChangeDTO();
            skuPriceChangeDTO.setSkuId(skuId);
            skuPriceChangeDTO.setFromPrice(from);
            skuPriceChangeDTO.setToPrice(toPrice);
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TopicConst.SKU_PRICE_CHANGE_TOPIC, JsonUtil.writeValueAsString(skuPriceChangeDTO));
            future.whenComplete(((sendResult, throwable) -> {
                if (throwable == null) {
                    // 正常处理逻辑
                    log.info("Message sent successfully: {}", sendResult);
                } else {
                    // 异常处理逻辑
                    log.error("Failed to send message due to: ", throwable);
                }
            }));
            from = toPrice;
            Thread.sleep(60 * 1000L);
        }
        return "success";
    }

    @RequestMapping("/sendToOnePartition/{key}")
    public String sendToOnePartition(@PathVariable(name = "key") String key) throws Exception {
        Long skuId = 1440L;
        BigDecimal toPrice = from.add(new BigDecimal(1));
        SkuPriceChangeDTO skuPriceChangeDTO = new SkuPriceChangeDTO();
        skuPriceChangeDTO.setSkuId(skuId);
        skuPriceChangeDTO.setFromPrice(from);
        skuPriceChangeDTO.setToPrice(toPrice);
        from = toPrice;
        //发送2次进行对比
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TopicConst.SKU_PRICE_CHANGE_TOPIC, key, JsonUtil.writeValueAsString(skuPriceChangeDTO));
        future.whenComplete(((sendResult, throwable) -> {
            if (throwable == null) {
                // 正常处理逻辑
                log.info("Message sent successfully: {}", sendResult);
            } else {
                // 异常处理逻辑
                log.error("Failed to send message due to: ", throwable);
            }
        }));
        //
        Thread.sleep(20 * 1000L);
        ProducerRecord<String, String> record = new ProducerRecord<>(TopicConst.SKU_PRICE_CHANGE_TOPIC, key, JsonUtil.writeValueAsString(skuPriceChangeDTO));
        Future<RecordMetadata> send = customPartitionerProducer.send(record);
        try {
            RecordMetadata recordMetadata = send.get();
            log.info("Message sent successfully: {}", recordMetadata);
        } catch (Exception e) {
            log.error("Failed to send message due to: ", e);
        }
        return "success";
    }


    @RequestMapping("/sendTrx/{key}")
    public String sendTrx(@PathVariable(name = "key") String key) throws Exception {
        Long skuId = 1440L;
        BigDecimal toPrice = from.add(new BigDecimal(1));
        SkuPriceChangeDTO skuPriceChangeDTO = new SkuPriceChangeDTO();
        skuPriceChangeDTO.setSkuId(skuId);
        skuPriceChangeDTO.setFromPrice(from);
        skuPriceChangeDTO.setToPrice(toPrice);
        from = toPrice;
        customTrxProducer.beginTransaction();
        customTrxProducer.send()
        //发送2次进行对比
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TopicConst.SKU_PRICE_CHANGE_TOPIC, key, JsonUtil.writeValueAsString(skuPriceChangeDTO));
        future.whenComplete(((sendResult, throwable) -> {
            if (throwable == null) {
                // 正常处理逻辑
                log.info("Message sent successfully: {}", sendResult);
            } else {
                // 异常处理逻辑
                log.error("Failed to send message due to: ", throwable);
            }
        }));
        //
        Thread.sleep(20 * 1000L);
        ProducerRecord<String, String> record = new ProducerRecord<>(TopicConst.SKU_PRICE_CHANGE_TOPIC, key, JsonUtil.writeValueAsString(skuPriceChangeDTO));
        Future<RecordMetadata> send = customPartitionerProducer.send(record);
        try {
            RecordMetadata recordMetadata = send.get();
            log.info("Message sent successfully: {}", recordMetadata);
        } catch (Exception e) {
            log.error("Failed to send message due to: ", e);
        }
        return "success";
    }

}
