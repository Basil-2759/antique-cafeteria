package com.basil.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.basil.VO.CuisineVO;
import com.basil.service.CuisineService;
import com.basil.DAO.CuisineDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author Basil
 * @create 2023/3/5 14:38
 * @description com.basil.controller antique-cafeteria
 */
@RestController
@RequestMapping("cuisine")
@RefreshScope
public class CuisineController {
    @Autowired
    private CuisineService cuisineService;

    @GetMapping("select/cuisine/all")
    public List<CuisineVO> selectAllInfo() {
        return cuisineService.selectCuisineAllInfo();
    }

    @GetMapping("select/cuisine/ids")
    public HashMap<Integer, String> selectCuisineByIds(@RequestParam(value = "cuisineIds", required = false) List<Integer> cuisineIds){
        return cuisineService.selectCuisineByIds(cuisineIds);
    }

    @GetMapping("select/cuisine/name/{cuisineName}")
    public Page<CuisineDO> selectCuisineByNames(@PathVariable String cuisineName, Integer pageNo, Integer pageSize) {
        return cuisineService.selectCuisineByNames(cuisineName, pageNo, pageSize);
    }

    @GetMapping("select/cuisine/flavour/{flavourName}")
    public List<CuisineVO> selectCuisineByFlavour(@PathVariable String flavourName) {
        return cuisineService.selectCuisineByFlavour(flavourName);
    }

    @GetMapping("select/cuisine/foodstuff")
    List<CuisineVO> selectCuisineByFoddstuff(@RequestParam(value = "foodstuffNames", required = false) List<String> foodstuffNames) {
        return cuisineService.selectCuisineByFoddstuff(foodstuffNames);
    }
}
