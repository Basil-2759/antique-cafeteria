package com.basil.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Time;

/**
 * @author Basil
 * @create 2023/3/4 15:53
 * @description 菜肴表所使用的实体类
 */
@Data
@TableName("cuisine")
public class TbCuisine {
    @TableId(value = "cuisine_id", type = IdType.AUTO)
    private Integer cuisineId;
    @TableField(value = "cuisine_name")
    private String cuisineName;
    @TableField(value = "flavour_id")
    private Integer flavourId;
    @TableField(value = "duration")
    private Time duration;
    @TableField(value = "price")
    private double price;
    @TableField(value = "remarks")
    private String remarks;
}
