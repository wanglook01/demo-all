package org.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.example.RocketMqWebApplication;
import org.example.constant.TopicConst;
import org.example.dto.SkuChangeDetailDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@SpringBootTest(classes = RocketMqWebApplication.class)
public class ProducerDetailTest {

    private List<SkuChangeDetailDTO> messages = new ArrayList<>();

    @Resource
    private MQProducer producer;

    @BeforeEach
    public void before() {
        for (int i = 0; i < 6; i++) {
            SkuChangeDetailDTO dto = new SkuChangeDetailDTO();
            dto.setSkuId(1250);
            dto.setKey(dto.getSkuId() + "" + i);
            dto.setDetail("修改内容:" + i);
            messages.add(dto);
        }
    }


    @Test
    public void send() throws Exception {
        for (SkuChangeDetailDTO message : messages) {
            String body = JSON.toJSONString(message);
            String key = message.getKey();
            Message msgDTO = new Message(TopicConst.DETAIL_TOPIC, "detail", key, body.getBytes());
            SendResult send = producer.send(msgDTO);
            log.info("send:{},{},{}", key, send.getSendStatus(), send.getMessageQueue().getQueueId());
        }
    }
}
