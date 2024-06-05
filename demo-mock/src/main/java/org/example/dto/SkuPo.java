package org.example.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_sku_index")
public class SkuPo {

    @TableId
    private Long id;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * name
     */
    private String name;


    @TableField("bi_id")
    private Integer biId;

    @TableField("sale_c1_id")
    private Integer saleC1Id;

}
