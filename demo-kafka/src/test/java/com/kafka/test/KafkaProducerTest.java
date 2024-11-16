package com.kafka.test;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.example.KafkaApplication;
import org.example.constant.TopicConst;
import org.example.dto.SkuSsuStockDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * sku_ssu_stock_change
 * 2个分片，2个副本
 */
@Slf4j
@SpringBootTest(classes = KafkaApplication.class)
public class KafkaProducerTest {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public List<SkuSsuStockDTO> getSkuSsuStockList() {
        List<SkuSsuStockDTO> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SkuSsuStockDTO dto = new SkuSsuStockDTO();
            dto.setSkuId("sku-" + i);
            dto.setSsuId("ssu-" + i);
            dto.setStock(i * 10);
            dto.setPrice(new BigDecimal(i * 10));
            list.add(dto);
        }
        return list;
    }


    @Test
    public void userChange() throws Exception {
        for (SkuSsuStockDTO dto : getSkuSsuStockList()) {
            String key = dto.getSkuId();
            String body = JSONObject.toJSONString(dto);
            ListenableFuture<SendResult<Object, Object>> send = kafkaTemplate.send(TopicConst.SKU_SSU_STOCK_CHANGE_TOPIC, key, body);
            send.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable ex) {
                    log.error("onFailure:", ex);
                }

                @Override
                public void onSuccess(SendResult<Object, Object> result) {
                    log.info("onSuccess:{}", result);
                }
            });
        }
        log.info("send.success1......");
        Thread.sleep(10000);
        log.info("send.success2......");
    }


}
