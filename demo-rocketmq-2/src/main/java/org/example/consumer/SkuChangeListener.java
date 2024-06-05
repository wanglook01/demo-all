package org.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "demo-rocketmq", topic = "sku_change")
public class SkuChangeListener implements RocketMQListener<MessageExt> {


    @Override
    public void onMessage(MessageExt messageExt) {
        log.info("{}:{}", this.getClass().getSimpleName(), messageExt);
    }
}
