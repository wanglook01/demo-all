package org.example.group.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_invoice_config")
public class InvoiceConfigPO {

    @TableId
    private Long id;

    private Long groupId;

    /**
     * 一级售卖分类id
     */
    private Integer saleClassOneId;

    /**
     * 一级售卖分类名称
     */
    private String saleClassOneName;

    /**
     * 发票种类 1 专票 2 普票
     */
    private Integer invoiceType;

    /**
     * 是否接受零税点 1 接受 2 不接受
     */
    private Integer acceptZeroTax;

    @TableField("c_t")
    private Long cT;

    @TableField("u_t")
    private Long uT;

    @TableField("is_deleted")
    private Integer isDeleted;
}
