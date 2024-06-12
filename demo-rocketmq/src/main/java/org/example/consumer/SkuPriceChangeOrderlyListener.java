package org.example.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.example.constant.TopicConst;
import org.example.dto.SkuChangePriceDTO;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "demo-rocketmq",
        topic = TopicConst.PRICE_CHANGE_TOPIC,
        maxReconsumeTimes = 0,
        consumeMode = ConsumeMode.ORDERLY)
public class SkuPriceChangeOrderlyListener implements RocketMQListener<MessageExt> {

    private static ConcurrentMap<String, AtomicInteger> messageAndTimes = new ConcurrentHashMap<>();

    @Override
    public void onMessage(MessageExt messageExt) {
        //获取当前次数，以及次数+1
        if (!messageAndTimes.containsKey(messageExt.getMsgId())) {
            messageAndTimes.put(messageExt.getMsgId(), new AtomicInteger(1));
        }
        log.warn("messageId:{},key:{},times:{}", messageExt.getMsgId(), messageExt.getKeys(), messageAndTimes.get(messageExt.getMsgId()).getAndIncrement());
        //正常消费消息
        String body = new String(messageExt.getBody());
        SkuChangePriceDTO dto = JSON.parseObject(body, SkuChangePriceDTO.class);
        if (dto.getPrice().equals(2)) {
            log.warn("messageId:{},key:{},error", messageExt.getMsgId(), messageExt.getKeys());
            throw new RuntimeException("");
        }
        log.warn("messageId:{},key:{},success", messageExt.getMsgId(), messageExt.getKeys());
    }
}
