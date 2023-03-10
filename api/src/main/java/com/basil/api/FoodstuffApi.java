package com.basil.api;

import com.basil.DAO.FoodstuffDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Basil
 * @create 2023/3/5 16:12
 * @description com.basil antique-cafeteria
 */
@FeignClient(value = "foodstuff", path = "/foodstuff")
public interface FoodstuffApi {
    /**
     * @description 根据食材ID查询食材名称
     * @return 列表类型的字符串
     * @param ids
     */
    @GetMapping("/select/foodstuff/ids")
    List<String> selectByFoodstuffIds(@RequestParam(value = "foodstuffIds", required = false) List<Integer> ids);

    /**
     * @description 根据食材名称查询食材ID
     * @return 列表类型的整型
     * @param foodstuffNames
     */
    @GetMapping("/select/foodstuff/names")
    List<FoodstuffDO> selectByFoodstuffNames(@RequestParam(value = "foodstuffNames", required = false) List<String> foodstuffNames);
}
