package org.example.business.common;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 和数据库是一一对应的
 */
@Data
@TableName("t_user")
public class UserPO {


    @TableId
    private Integer id;

    /**
     * 企业名称
     */
    private String name;

    private Integer status;


}
