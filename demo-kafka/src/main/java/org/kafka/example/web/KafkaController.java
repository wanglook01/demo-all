package org.kafka.example.web;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.kafka.example.constant.TopicConst;
import org.kafka.example.dto.SkuPriceChangeDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.utils.example.JsonUtil;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

/**
 * http://127.0.0.1:8888/kafka/send/ssu1239stock100
 */
@Slf4j
@Controller
@RequestMapping("/kafka")
@ResponseBody
public class KafkaController {

    public static BigDecimal from = new BigDecimal("1");

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    @RequestMapping("/send")
    public String sendMessage() throws Exception {
        Long skuId = 1396L;
        for (int i = 0; i < 100; i++) {
            BigDecimal toPrice = from.add(new BigDecimal(1));
            SkuPriceChangeDTO skuPriceChangeDTO = new SkuPriceChangeDTO();
            skuPriceChangeDTO.setSkuId(skuId);
            skuPriceChangeDTO.setFromPrice(from);
            skuPriceChangeDTO.setToPrice(toPrice);
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TopicConst.SKU_PRICE_CHANGE_TOPIC, JsonUtil.writeValueAsString(skuPriceChangeDTO));
            future.whenComplete(((sendResult, throwable) -> {
                if (throwable == null) {
                    // 正常处理逻辑
                    log.info("Message sent successfully: {}", sendResult);
                } else {
                    // 异常处理逻辑
                    log.error("Failed to send message due to: ", throwable);
                }
            }));
            from = toPrice;
            Thread.sleep(60 * 1000L);
        }
        return "success";
    }

}
