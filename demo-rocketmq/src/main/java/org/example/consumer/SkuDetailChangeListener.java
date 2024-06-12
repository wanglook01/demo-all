package org.example.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.example.constant.TopicConst;
import org.example.dto.SkuChangeDetailDTO;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "demo-rocketmq-3",
        topic = TopicConst.DETAIL_TOPIC,
        maxReconsumeTimes = 10)
public class SkuDetailChangeListener implements RocketMQListener<MessageExt> {


    @Override
    public void onMessage(MessageExt messageExt) {
        String body = new String(messageExt.getBody());
        SkuChangeDetailDTO dto = JSON.parseObject(body, SkuChangeDetailDTO.class);
        if (dto.getKey().equals("12501")) {
            throw new RuntimeException("12501异常，messageId:" + messageExt.getMsgId());
        }
        log.info("{}:{}", this.getClass().getSimpleName(), new String(messageExt.getBody()));
    }
}
