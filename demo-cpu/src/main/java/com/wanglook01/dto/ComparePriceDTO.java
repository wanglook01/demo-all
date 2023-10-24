package com.wanglook01.dto;

import com.google.common.collect.Lists;
import com.wanglook01.util.RandomUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ComparePriceDTO {

    private String morePriceLinkTitle;

    private String tag;

    private List<String> bottomReminderList;

    private String priceCount;

    public static ComparePriceDTO get() {
        ComparePriceDTO comparePriceDTO = new ComparePriceDTO();
        comparePriceDTO.setMorePriceLinkTitle(RandomUtil.randomStr(10));
        comparePriceDTO.setTag(RandomUtil.randomStr(10));
        comparePriceDTO.setBottomReminderList(Lists.newArrayList(RandomUtil.randomStr(10), RandomUtil.randomStr(10), RandomUtil.randomStr(10)));
        comparePriceDTO.setPriceCount(RandomUtil.randomStr(10));
        return comparePriceDTO;
    }

}
