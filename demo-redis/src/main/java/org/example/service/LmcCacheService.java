package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.LmcGetAdPageDataByIdResDTO;
import org.example.util.CacheKeyUtil;
import org.example.util.JsonUtil;
import org.example.util.ThreadPoolUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;

@Service
@Slf4j
public class LmcCacheService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    public void savePageIdConfig() {
        String jsonStr = "{\"page_name\":\"C端新版首页-已启用\",\"bg_end_color\":\"rgba(248, 248, 248, 1)\",\"bg_start_color\":\"rgba(248, 248, 248, 1)\",\"bg_img\":{\"height\":1119,\"width\":1125,\"img_type\":1,\"img_url\":\"https://img-oss.yunshanmeicai.com/spruce_material/5f48bb2892f2373fe6e34b615ea95d25\"},\"is_share\":0,\"share_name\":\"\",\"share_img\":\"\",\"share_url\":\"\",\"share_desc\":\"\",\"page_id\":\"1002583\",\"pb\":0,\"page_data\":[{\"id\":\"158383\",\"data\":[{\"params\":\"1002583_158383_1\",\"data_source\":\"1\"},{\"params\":\"1002583_158383_2\",\"data_source\":\"1\"},{\"params\":\"1002583_158383_3\",\"data_source\":\"1\"},{\"params\":\"1002583_158383_4\",\"data_source\":\"1\"},{\"params\":\"1002583_158383_5\",\"data_source\":\"1\"},{\"params\":\"1002583_158383_6\",\"data_source\":\"1\"},{\"params\":\"1002583_158383_7\",\"data_source\":\"1\"},{\"params\":\"1002583_158383_8\",\"data_source\":\"1\"},{\"params\":\"1002583_158383_9\",\"data_source\":\"1\"}],\"style\":{\"scrollerPosition\":1,\"ps\":0,\"pt\":0,\"ms\":0,\"mt\":0,\"is\":0,\"bgImg\":{\"height\":0,\"width\":0,\"img_type\":1,\"img_url\":\"\"},\"type\":\"all\",\"zzImg\":{\"height\":0,\"width\":0,\"img_type\":1,\"img_url\":\"\"},\"br\":16,\"pb\":0,\"mb\":0,\"name\":\"轮播\"},\"code\":\"common_scroller\",\"type\":\"all\"},{\"id\":\"225025\",\"data\":[{\"params\":\"1002583_225025_1\",\"data_source\":\"1\"}],\"style\":{\"br\":16,\"market_goods_layout\":\"3xN\",\"pb\":20,\"ps\":20,\"pt\":12,\"attachImg1\":{\"height\":256,\"width\":194,\"img_type\":1,\"img_url\":\"https://img-oss.yunshanmeicai.com/spruce_material/0dffbf07aa0eeaf274f02dc605e49ee2\"},\"ms\":20,\"mt\":24,\"name\":\"测试勿动\",\"bgImg\":{\"height\":342,\"width\":1065,\"img_type\":1,\"img_url\":\"https://img-oss.yunshanmeicai.com/spruce_material/74b376f96b2b17d7bc800626ef2bde3e\"},\"type\":\"3xN\"},\"code\":\"marketing_goods\",\"type\":\"3xN\"},{\"id\":\"158386\",\"data\":[{\"params\":\"1002583_158386_1\",\"data_source\":\"1\"},{\"params\":\"1002583_158386_2\",\"data_source\":\"1\"},{\"params\":\"1002583_158386_3\",\"data_source\":\"1\"},{\"params\":\"1002583_158386_4\",\"data_source\":\"1\"},{\"params\":\"1002583_158386_5\",\"data_source\":\"1\"},{\"params\":\"1002583_158386_6\",\"data_source\":\"1\"},{\"params\":\"1002583_158386_7\",\"data_source\":\"1\"},{\"params\":\"1002583_158386_8\",\"data_source\":\"1\"},{\"params\":\"1002583_158386_9\",\"data_source\":\"1\"},{\"params\":\"1002583_158386_10\",\"data_source\":\"1\"}],\"style\":{\"cornerFontColor\":\"#FFFFFF\",\"ps\":16,\"pt\":24,\"ms\":20,\"mt\":24,\"bgColorStart\":\"#FFFFFF\",\"cornerBgColor\":\"#FF6F14\",\"is\":0,\"bgImg\":{\"height\":626,\"width\":1125,\"img_type\":1,\"img_url\":\"https://img-oss.yunshanmeicai.com/spruce_material/97612bff63955b8785d25d569be20e95\"},\"type\":\"5x2\",\"bgType1\":\"img\",\"textColor\":\"#000000\",\"br\":16,\"pb\":24,\"maxLine\":2,\"mb\":0,\"iconType\":\"5x2\",\"name\":\"icon模块\",\"showMore\":\"5x2\",\"bgColorEnd\":\"#FFFFFF\",\"shadowColor\":\"rgba(0, 0, 0, 0.1)\",\"lineCount\":5},\"code\":\"common_icon\",\"type\":\"5x2\"},{\"id\":\"170890\",\"data\":[{\"params\":\"1002583_170890_1\",\"data_source\":\"1\"}],\"style\":{\"pb\":0,\"ps\":0,\"pt\":0,\"mb\":0,\"ms\":0,\"mt\":20,\"name\":\"通知条（城市勿动）\",\"bgColorStart\":\"rgba(245, 245, 245, 1)\",\"bgColorEnd\":\"rgba(245, 245, 245, 1)\",\"is\":0,\"bgImg\":{\"height\":0,\"width\":0,\"img_type\":1,\"img_url\":\"\"},\"type\":\"1xN\"},\"code\":\"common_image\",\"type\":\"1xN\"},{\"id\":\"158389\",\"data\":[{\"params\":\"1002583_158389_1\",\"data_source\":\"1\"}],\"style\":{\"popupType\":\"basic\",\"name\":\"弹窗\",\"type\":\"basic\"},\"code\":\"common_popup\",\"type\":\"basic\"},{\"id\":\"158392\",\"data\":[{\"params\":\"1002583_158392_1\",\"data_source\":\"1\"}],\"style\":{\"floatWindowType\":\"1\",\"name\":\"飘窗\",\"type\":\"1\"},\"code\":\"float_window\",\"type\":\"1\"},{\"id\":\"211933\",\"data\":[{\"params\":\"1002583_211933_1\",\"data_source\":\"1\"}],\"style\":{\"cornerFontColor\":\"rgba(255, 96, 59, 1)\",\"ms\":20,\"mt\":7,\"bgColorStart\":\"rgba(255, 255, 255, 0)\",\"cornerBgColor\":\"#FFFFFF\",\"bgImg\":{\"height\":390,\"width\":1065,\"img_type\":1,\"img_url\":\"https://img-oss.yunshanmeicai.com/spruce_material/7aadffbd0bbb603da4fab63e272533ba\"},\"type\":\"promotion\",\"textColor\":\"#FFFFFF\",\"br\":16,\"attachImg1\":{\"height\":120,\"width\":1005,\"img_type\":1,\"img_url\":\"https://img-oss.yunshanmeicai.com/spruce_material/e8833255442a7ab619ffd013055d3cfb\"},\"mb\":0,\"name\":\"秒杀\",\"bgColorEnd\":\"rgba(255, 255, 255, 0)\",\"shadowColor\":\"rgba(0, 0, 0, 0.1)\"},\"code\":\"mc_seckill\",\"type\":\"promotion\"},{\"id\":\"158395\",\"data\":[{\"params\":\"1002583_158395_1\",\"data_source\":\"1\"}],\"style\":{\"pb\":0,\"ps\":0,\"pt\":0,\"mb\":0,\"ms\":0,\"mt\":0,\"name\":\"通栏\",\"bgColorStart\":\"rgba(245, 245, 245, 0)\",\"bgColorEnd\":\"rgba(245, 245, 245, 0)\",\"is\":0,\"bgImg\":{\"height\":0,\"width\":0,\"img_type\":1,\"img_url\":\"\"},\"type\":\"1xN\"},\"code\":\"common_image\",\"type\":\"1xN\"},{\"id\":\"218554\",\"data\":[{\"params\":\"1002583_218554_1\",\"data_source\":\"1\"}],\"style\":{\"pb\":0,\"ps\":0,\"pt\":0,\"mb\":0,\"ms\":0,\"mt\":0,\"name\":\"北京夜市通栏（勿动）\",\"bgColorStart\":\"rgba(255, 255, 255, 0)\",\"bgColorEnd\":\"rgba(255, 255, 255, 0)\",\"is\":0,\"bgImg\":{\"height\":0,\"width\":0,\"img_type\":1,\"img_url\":\"\"},\"type\":\"1xN\"},\"code\":\"common_image\",\"type\":\"1xN\"},{\"id\":\"158401\",\"data\":[{\"params\":\"1002583_158401_1\",\"data_source\":\"1\"},{\"params\":\"1002583_158401_2\",\"data_source\":\"1\"}],\"style\":{\"pb\":0,\"ps\":0,\"pt\":0,\"mb\":0,\"ms\":20,\"mt\":10,\"name\":\"广告位2*N\",\"bgColorStart\":\"#F5F5F5\",\"bgColorEnd\":\"#F5F5F5\",\"is\":10,\"bgImg\":{\"height\":0,\"width\":0,\"img_type\":1,\"img_url\":\"\"},\"type\":\"2xN\"},\"code\":\"common_image\",\"type\":\"2xN\"},{\"id\":\"158404\",\"data\":[{\"params\":\"1002583_158404_1\",\"data_source\":\"1\"},{\"params\":\"1002583_158404_2\",\"data_source\":\"1\"},{\"params\":\"1002583_158404_3\",\"data_source\":\"1\"},{\"params\":\"1002583_158404_4\",\"data_source\":\"1\"}],\"style\":{\"pb\":0,\"ps\":0,\"pt\":0,\"mb\":0,\"ms\":15,\"mt\":15,\"name\":\"广告位4*N\",\"bgColorStart\":\"#F5F5F5\",\"bgColorEnd\":\"#F5F5F5\",\"is\":10,\"bgImg\":{\"height\":0,\"width\":0,\"img_type\":1,\"img_url\":\"\"},\"type\":\"4xN\"},\"code\":\"common_image\",\"type\":\"4xN\"},{\"id\":\"158407\",\"data\":[{\"params\":\"1002583_158407_1\",\"data_source\":\"1\"},{\"params\":\"1002583_158407_2\",\"data_source\":\"1\"},{\"params\":\"1002583_158407_3\",\"data_source\":\"1\"},{\"params\":\"1002583_158407_4\",\"data_source\":\"1\"},{\"params\":\"1002583_158407_5\",\"data_source\":\"1\"},{\"params\":\"1002583_158407_6\",\"data_source\":\"1\"},{\"params\":\"1002583_158407_7\",\"data_source\":\"1\"},{\"params\":\"1002583_158407_8\",\"data_source\":\"1\"}],\"style\":{\"unselectSubTitleColor\":\"#827F7F\",\"selectedSubTitleColor\":\"#FFFFFF\",\"mt\":0,\"name\":\"图文锚点\",\"bgColorStart\":\"#FFFFFF\",\"bgColorEnd\":\"#FFFFFF\",\"unselectTitleColor\":\"#333333\",\"bgImg\":{\"height\":300,\"width\":750,\"img_type\":1,\"img_url\":\"https://img-oss.yunshanmeicai.com/spruce_material/bd1e647eff4058fc684e38a1731000f6\"},\"subTitleBgColor\":\"rgba(39, 185, 65, 1)\",\"type\":\"basic\",\"bgType1\":\"img\",\"selectedTitleColor\":\"rgba(39, 185, 65, 1)\"},\"code\":\"image_text_anchor\",\"type\":\"basic\"}]}";
        LmcGetAdPageDataByIdResDTO post = JsonUtil.readValue(jsonStr, LmcGetAdPageDataByIdResDTO.class);
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String key = CacheKeyUtil.getPageIdKey(post.getPage_id());
        opsForValue.set(key, post, Duration.ofMinutes(20));
        log.info("savePageIdConfig success,key:{}", key);
    }


    public void getPageIdConfig() {
        try {
            ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
            String key = "lmc:page:1002583";
            long start = System.currentTimeMillis();
            Object o = opsForValue.get(key);
            log.info("getPageIdConfig success,time:{},lmcPageById:{}", System.currentTimeMillis() - start, o);
        } catch (Exception e) {
            log.error("getPageIdConfig", e);
        }
    }


    public void concurrentGet(int times) {
        for (int i = 0; i < times; i++) {
            ThreadPoolUtil.run(this::getPageIdConfig);
        }
        log.info("concurrentGet success");
    }


}
