package com.kafka.test;


import lombok.extern.slf4j.Slf4j;
import org.example.KafkaApplication;
import org.example.web.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest(classes = KafkaApplication.class)
public class KafkaProducerTest2 {




    @Resource
    private ProducerService producerService;



    @Test
    public void trx() throws Exception {
        List<String> list = Arrays.asList("message1", "abc", "message3");
        producerService.sendInTrx(list);
    }


}
