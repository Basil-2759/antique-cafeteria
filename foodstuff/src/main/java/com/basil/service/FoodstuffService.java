package com.basil.service;

import com.basil.DAO.FoodstuffDO;

import java.util.List;

/**
 * @author Basil
 * @create 2023/3/5 16:11
 * @description com.basil.service antique-cafeteria
 */
public interface FoodstuffService {
    /**
     * @description 根据食材ID查询食材名称
     * @return 列表类型的字符串
     * @param foodstuffIds
     */
    List<String> selectByIds(List<Integer> foodstuffIds);

    /**
     * @description 根据食材名称查询食材ID
     * @return 列表类型的整型
     * @param foodstuffNames
     */
    List<FoodstuffDO> selectByNames(List<String> foodstuffNames);
}
