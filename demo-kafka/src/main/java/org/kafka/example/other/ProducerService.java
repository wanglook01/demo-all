package org.kafka.example.other;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ProducerService {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    /*@Transactional
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
            *//*if (oneMessage.equals("abc")) {
                throw new RuntimeException("oneMessageFail......");
            }*//*
        }
    }*/
}
