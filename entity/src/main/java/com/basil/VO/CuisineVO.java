package com.basil.VO;

import com.basil.DAO.CuisineDO;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Time;

/**
 * @author Basil
 * @create 2023/3/4 15:40
 * @description 菜肴实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuisineVO {
    private String cuisineName;

    private String flavourName;

    private Time duration;

    private Double price;

    private String remarks;

    private Integer pageNo;

    private Integer pageSize;

    /**
     * @param cuisineDO
     * @description 构造器
     */
//    public CuisineVO(CuisineDO cuisineDO) {
//        super(cuisineDO);
//    }
}
