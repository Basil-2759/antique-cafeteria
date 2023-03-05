package com.basil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author Basil
 * @create 2023/3/4 17:37
 * @description com.basil antique-cafeteria
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;

    private Integer cuisineId;

    private Timestamp createTime;
}
