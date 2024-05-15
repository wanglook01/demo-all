package org.example.service;

import org.example.dto.GetSkuListResDTO;
import org.example.protocol.GetSkuListResDTOProto;
import org.example.util.CacheKeyUtil;
import org.example.util.ProtoBufUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;

@Service
public class RedisCacheService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedisTemplate<String, Object> protoRedisTemplate;

    public String fillIn4(int i) {
        switch ((i + "").length()) {
            case 1:
                return "000" + i;
            case 2:
                return "00" + i;
            case 3:
                return "0" + i;
            default:
                return "" + i;
        }
    }

    public void save() {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        for (int i = 0; i < 10000; i++) {
            String key = "key:" + fillIn4(i);
            String value = "value:" + fillIn4(i);
            valueOperations.set(key, value, Duration.ofMinutes(10));
        }
    }


    public void saveSku() {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        Long time = System.currentTimeMillis() / 1000;
        long companyId = 7730000L;
        long skuId = 1239L;
        for (int i = 0; i < 10000; i++) {
            companyId += 1;
            skuId += 1;
            String key = CacheKeyUtil.getCompanySkuKey(companyId);
            GetSkuListResDTO dto = new GetSkuListResDTO();
            dto.setCompanyId(companyId);
            dto.setSaleC1Id((int) skuId);
            dto.setBiId(skuId);
            dto.setSkuId(skuId);
            dto.setSource(i);
            dto.setLastOrderTime(time.intValue());
            dto.setChannel(i);
            dto.setBuyNum(i);
            dto.setUT(time);
            opsForValue.set(key, dto, Duration.ofMinutes(10));
        }
    }

    public void saveSkuProto() {
        ValueOperations<String, Object> protoValueOperations = protoRedisTemplate.opsForValue();
        long time = System.currentTimeMillis() / 1000;
        long companyId = 7730000L;
        long skuId = 1239L;
        for (int i = 0; i < 10000; i++) {
            companyId += 1;
            skuId += 1;
            String key = CacheKeyUtil.getCompanySkuKey(companyId);
            GetSkuListResDTOProto.Builder builder = new GetSkuListResDTOProto.Builder();
            GetSkuListResDTOProto dto = builder.setCompanyId(companyId)
                    .setSaleC1Id((int) skuId)
                    .setBiId(skuId)
                    .setSkuId(skuId)
                    .setSource(i)
                    .setLastOrderTime((int) time)
                    .setChannel(i)
                    .setBuyNum(i)
                    .setUT(time).build();
            protoValueOperations.set(key, ProtoBufUtil.serialize(dto), Duration.ofMinutes(10));
        }
    }

    public GetSkuListResDTO get() {
        ValueOperations<String, Object> opsForValue = protoRedisTemplate.opsForValue();
        Object o = opsForValue.get("smart_list:7730001");
        GetSkuListResDTOProto deserialize = ProtoBufUtil.deserialize((byte[]) o, GetSkuListResDTOProto.class);
        GetSkuListResDTO dto = new GetSkuListResDTO();
        dto.setCompanyId(deserialize.getCompanyId());
        dto.setSaleC1Id(deserialize.getSaleC1Id());
        dto.setBiId(deserialize.getBiId());
        dto.setSkuId(deserialize.getSkuId());
        dto.setSource(deserialize.getSource());
        dto.setLastOrderTime(deserialize.getLastOrderTime());
        dto.setChannel(deserialize.getChannel());
        dto.setBuyNum(deserialize.getBuyNum());
        dto.setUT(deserialize.getUT());
        return dto;
    }
}
