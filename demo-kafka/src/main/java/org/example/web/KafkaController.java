package org.example.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

import static org.example.constant.TopicConst.SKU_SSU_STOCK_CHANGE_TOPIC;

/**
 * http://127.0.0.1:8888/kafka/send/ssu1239stock100
 */
@Slf4j
@Controller
@RequestMapping("/kafka")
@ResponseBody
public class KafkaController {


    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(SKU_SSU_STOCK_CHANGE_TOPIC, message);
        send.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("error", ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("success:{}", result);
            }
        });
        SendResult<String, String> stringStringSendResult = send.get();
        log.info("stringStringSendResult:{}", stringStringSendResult);
        return "success";
    }

}
