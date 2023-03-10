package com.basil.DAO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Time;
import java.util.Optional;

/**
 * @author Basil
 * @create 2023/3/4 15:53
 * @description 菜肴表所使用的实体类
 */
@Data
@NoArgsConstructor
@TableName("cuisine")
public class CuisineDO extends Model<CuisineDO> {
    @TableId(value = "cuisine_id", type = IdType.AUTO)
    private Integer cuisineId;
    @TableField(value = "cuisine_name")
    private String cuisineName;
    @TableField(value = "flavour_id")
    private Integer flavourId;
    @TableField(value = "duration")
    private Time duration;
    @TableField(value = "price")
    private Double price;
    @TableField(value = "remarks")
    private String remarks;

    /**
     * @description 构造器
     * @param cuisineDO
     */
    public CuisineDO(CuisineDO cuisineDO) {
        Optional.ofNullable(cuisineDO).ifPresent(c -> {
            this.cuisineId = c.getCuisineId();
            this.cuisineName = c.getCuisineName();
            this.flavourId = c.getFlavourId();
            this.duration = c.getDuration();
            this.price = c.getPrice();
            this.remarks = c.getRemarks();
        });
    }
}
