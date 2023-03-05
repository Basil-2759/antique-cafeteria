package com.basil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Basil
 * @create 2023/3/4 17:34
 * @description com.basil antique-cafeteria
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foodstuff {
    private Integer foodstuffId;
    private String foodstuffName;
}
