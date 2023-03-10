package com.basil.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.basil.DAO.CuisineDO;
import com.basil.VO.CuisineVO;

import java.util.HashMap;
import java.util.List;

/**
 * @author Basil
 * @create 2023/3/5 14:42
 * @description com.basil.mapper antique-cafeteria
 */
public interface CuisineService {
    /**
     * @return 列表类型的Cuisine
     * @description 查找所有菜肴信息，无条件
     */
    List<CuisineVO> selectCuisineAllInfo();

    /**
     * @param 口味ID
     * @return 口味名称
     * @description 查找口味名称，根据口味ID
     */
    String selectFlavourById(Integer flavourId);

    /**
     * @param 口味IDs
     * @return 口味名称
     * @description 查找口味名称，根据口味ID集合
     */
    HashMap<Integer, String> selectFlavourByIds(List<Integer> flavourIds);

    /**
     * @param 菜肴IDs
     * @return 菜肴名称
     * @description 查找菜肴名称，根据菜肴ID集合
     */
    HashMap<Integer, String> selectCuisineByIds(List<Integer> cuisineIds);

    /**
     * @param 菜肴IDs
     * @return 菜肴信息
     * @description 模糊查询菜肴信息，根据菜肴名称
     */
    Page<CuisineDO> selectCuisineByNames(String cuisineName, Integer pageNo, Integer pageSize);

    /**
     * @param 口味名称
     * @return 菜肴信息
     * @description 查询菜肴信息，根据口味名称
     */
    List<CuisineVO> selectCuisineByFlavour(String flavourName);

    /**
     * @param
     * @return 菜肴信息
     * @description 查询菜肴信息，根据食材名称
     */
    List<CuisineVO> selectCuisineByFoddstuff(List<String> foodstuffNames);
}
