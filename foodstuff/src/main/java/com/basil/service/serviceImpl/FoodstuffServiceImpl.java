package com.basil.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.basil.mapper.FoodstuffMapper;
import com.basil.service.FoodstuffService;
import com.basil.DAO.FoodstuffDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Basil
 * @create 2023/3/5 16:12
 * @description com.basil.service.serviceImpl antique-cafeteria
 */
@Service
public class FoodstuffServiceImpl implements FoodstuffService {
    @Autowired
    private FoodstuffMapper foodstuffMapper;

    @Override
    public List<String> selectByIds(List<Integer> foodstuffIds) {
        List<FoodstuffDO> foodstuffDOS = foodstuffMapper.selectBatchIds(foodstuffIds);

        return foodstuffDOS.stream().map(FoodstuffDO::getFoodstuffName).collect(Collectors.toList());
    }

    @Override
    public List<FoodstuffDO> selectByNames(List<String> foodstuffNames) {
        List<FoodstuffDO> foodstuffDOS = foodstuffMapper.selectList(
                new LambdaQueryWrapper<FoodstuffDO>().in(FoodstuffDO::getFoodstuffName, foodstuffNames)
        );

        return foodstuffDOS;
    }
}
