package com.basil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Basil
 * @create 2023/3/4 17:41
 * @description com.basil.table antique-cafeteria
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relationship {
    private Integer relationshipId;

    private Integer cuisineId;

    private Integer foodstuffId;
}
