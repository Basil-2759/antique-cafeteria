package com.basil.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Basil
 * @create 2023/3/4 17:42
 * @description 关系表所使用的实体类
 */
@Data
@TableName("relationship")
public class TbRelationship {
    @TableId(value = "relationship_id", type = IdType.AUTO)
    private Integer relationshipId;

    @TableField(value = "cuisine_id")
    private Integer cuisineId;

    @TableField(value = "foodstuff_id")
    private Integer foodstuffId;
}
