package org.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.selector.SelectMessageQueueByHash;
import org.apache.rocketmq.common.message.Message;
import org.example.RocketMqWebApplication;
import org.example.constant.TopicConst;
import org.example.dto.SkuChangePriceDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@SpringBootTest(classes = RocketMqWebApplication.class)
public class ProducerPriceTest {

    private List<SkuChangePriceDTO> messages = new ArrayList<>();

    @Resource
    private MQProducer producer;

    @BeforeEach
    public void before() {
        for (int i = 0; i < 6; i++) {
            SkuChangePriceDTO dto = new SkuChangePriceDTO();
            dto.setSkuId(1239);
            dto.setPrice(i);
            messages.add(dto);
        }
    }


    @Test
    public void send() throws Exception {
        for (SkuChangePriceDTO message : messages) {
            String body = JSON.toJSONString(message);
            String key = message.getSkuId() + "" + message.getPrice();
            Message msgDTO = new Message(TopicConst.PRICE_CHANGE_TOPIC, "tag", key, body.getBytes());
            SendResult send = producer.send(msgDTO, new SelectMessageQueueByHash(), message.getSkuId());
            log.info("send:{},{},{}", key, send.getSendStatus(), send.getMessageQueue().getQueueId());
        }
    }
}
