package com.basil.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Basil
 * @create 2023/3/4 17:39
 * @description 订单表所使用的实体类
 */
@Data
@TableName("order")
public class TbOrder {
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @TableField(value = "cuisine_id")
    private Integer cuisineId;

    @TableField(value = "create_time")
    private Timestamp createTime;
}
