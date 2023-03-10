package com.basil.api;

import com.basil.DAO.CuisineDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @author Basil
 * @create 2023/3/5 14:36
 * @description com.basil antique-cafeteria
 */
@FeignClient(value = "cuisine", path = "/cuisine")
public interface CuisineApi {
    /**
     * @return 列表类型的 Cuisine
     * @description 查找所有菜肴信息，无条件
     */
    @GetMapping("/select/cuisine/all")
    List<CuisineDO> selectAllInfo();

    @GetMapping("select/cuisine/ids")
    HashMap<Integer, String> selectCuisineByIds(@RequestParam(value = "cuisineIds", required = false) List<Integer> cuisineIds);

}
