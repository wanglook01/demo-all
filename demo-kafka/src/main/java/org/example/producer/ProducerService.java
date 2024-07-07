package org.example.producer;


import lombok.extern.slf4j.Slf4j;
import org.example.constant.TopicConst;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ProducerService {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @Transactional
    public void sendInTrx(List<String> messages) {
        for (String oneMessage : messages) {
            ListenableFuture<SendResult<Object, Object>> send = kafkaTemplate.send(TopicConst.TRX_TOPIC, oneMessage);
            send.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable ex) {
                    log.error("message:{},error", oneMessage, ex);
                }

                @Override
                public void onSuccess(SendResult<Object, Object> result) {
                    log.info("message:{},success", oneMessage);
                }
            });
            /*if (oneMessage.equals("abc")) {
                throw new RuntimeException("oneMessageFail......");
            }*/
        }
    }
}
