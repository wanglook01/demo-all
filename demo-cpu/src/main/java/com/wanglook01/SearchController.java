package com.wanglook01;

import com.wanglook01.dto.SuSkuInfoResDTO;
import com.wanglook01.util.AESUtil;
import com.wanglook01.util.BeanUtil;
import com.wanglook01.util.JsonUtil;
import com.wanglook01.util.SkuFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/entrance/search")
public class SearchController {

    @RequestMapping("/getSearchResult")
    @ResponseBody
    public Object getSearchResult() {
        List<SuSkuInfoResDTO> skuList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            skuList.add(SkuFactory.generateOneSkuWith2Ssu());
        }
        //筛选给前端吐出的字段
        List<SuSkuInfoResDTO> collect = skuList.stream().map(BeanUtil::filtrateNeedFields).collect(Collectors.toList());
        return AESUtil.encrypt(JsonUtil.writeValueAsString(collect));
    }


}
