package com.basil.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Basil
 * @create 2023/3/4 17:33
 * @description 口味表所使用的实体类
 */
@Data
@TableName("flavour")
public class TbFlavour {
    @TableId(value = "flavour_id", type = IdType.AUTO)
    private Integer flavourId;

    @TableField(value = "flavour_name")
    private String flavourName;
}
