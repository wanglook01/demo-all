package com.kafka.test;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.example.KafkaApplication;
import org.example.constant.TopicConst;
import org.example.dto.UserChangeDTO;
import org.example.producer.ProducerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest(classes = KafkaApplication.class)
public class KafkaTestProducer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;


    @Resource
    private ProducerService producerService;

    static List<UserChangeDTO> userList = new ArrayList<>();

    @BeforeEach
    public void fill() {
        for (int i = 0; i < 5; i++) {
            UserChangeDTO dto = new UserChangeDTO();
            dto.setUserId(i);
            dto.setUserName("user" + i);
            dto.setPhone(Integer.parseInt("135122888" + i));
            userList.add(dto);
        }
    }


    @Test
    public void userChange() throws Exception {
        for (UserChangeDTO dto : userList) {
            String key = dto.getUserName();
            String body = JSONObject.toJSONString(dto);
            ListenableFuture<SendResult<Object, Object>> send = kafkaTemplate.send(TopicConst.USER_CONCURRENTLY_TOPIC, key, body);
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


    @Test
    public void trx() throws Exception {
        List<String> list = Arrays.asList("message1", "abc", "message3");
        producerService.sendInTrx(list);
    }


}
