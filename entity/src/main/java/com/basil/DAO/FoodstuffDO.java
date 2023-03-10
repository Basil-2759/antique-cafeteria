package com.basil.DAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Basil
 * @create 2023/3/4 17:36
 * @description 食材表所使用的实体类
 */
@Data
@TableName("foodstuff")
public class FoodstuffDO {
    @TableId(value = "foodstuff_id", type = IdType.AUTO)
    private Integer foodstuffId;

    @TableField(value = "foodstuff_name")
    private String foodstuffName;
}
