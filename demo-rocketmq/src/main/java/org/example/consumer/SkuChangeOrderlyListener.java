package org.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "demo-rocketmq", topic = "sku_change_orderly", maxReconsumeTimes = 3, consumeMode = ConsumeMode.ORDERLY)
public class SkuChangeOrderlyListener implements RocketMQListener<MessageExt> {


    @Override
    public void onMessage(MessageExt messageExt) {
        String body = new String(messageExt.getBody());
        if (body.equals("zhangsan")) {
            throw new RuntimeException("");
        }
        log.info("{}:{}", this.getClass().getSimpleName(), new String(messageExt.getBody()));
    }
}
