package com.basil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

/**
 * @author Basil
 * @create 2023/3/4 15:40
 * @description 菜肴实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuisine {
    private Integer cuisineId;

    private String cuisineName;

    private Integer flavourId;

    private Time duration;

    private double price;

    private String remarks;
}
