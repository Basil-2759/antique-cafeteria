package com.basil.controller;

import com.basil.service.FoodstuffService;
import com.basil.DAO.FoodstuffDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Basil
 * @create 2023/3/5 16:11
 * @description com.basil.controller antique-cafeteria
 */
@RestController
@RequestMapping("foodstuff")
@RefreshScope
public class FoodstuffController {
    @Autowired
    private FoodstuffService foodstuffService;

    @GetMapping("select/foodstuff/ids")
    public List<String> selectByFoodstuffIds(@RequestParam(value = "foodstuffIds", required = false) List<Integer> foodstuffIds) {
        return foodstuffService.selectByIds(foodstuffIds);
    }

    @GetMapping("select/foodstuff/names")
    public List<FoodstuffDO> selectByFoodstuffNames(@RequestParam(value = "foodstuffNames", required = false) List<String> foodstuffNames) {
        return foodstuffService.selectByNames(foodstuffNames);
    }
}
