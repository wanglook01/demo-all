package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetSkuListResDTO {

    private Long companyId;

    private Integer saleC1Id;

    private Long biId;

    private Long skuId;

    /**
     * 来源 0:商户添加 1:下单写入
     */
    private Integer source;

    private Integer lastOrderTime;

    private Integer channel;

    private Integer buyNum;

    private Long uT;
}
