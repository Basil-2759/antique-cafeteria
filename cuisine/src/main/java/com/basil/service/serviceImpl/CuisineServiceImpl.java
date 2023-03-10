package com.basil.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.basil.DAO.FlavourDO;
import com.basil.DAO.RelationshipDO;
import com.basil.DAO.FoodstuffDO;
import com.basil.VO.CuisineVO;
import com.basil.api.FoodstuffApi;
import com.basil.mapper.CuisineMapper;
import com.basil.mapper.FlavourMapper;
import com.basil.mapper.RelationshipMapper;
import com.basil.service.CuisineService;
import com.basil.DAO.CuisineDO;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Basil
 * @create 2023/3/5 14:43
 * @description com.basil.service.serviceImpl antique-cafeteria
 */
@Service
public class CuisineServiceImpl extends ServiceImpl<CuisineMapper, CuisineDO> implements CuisineService {
    @Resource
    private CuisineMapper cuisineMapper;

    @Resource
    private FlavourMapper flavourMapper;

    @Resource
    private RelationshipMapper relationshipMapper;

    @Resource
    private FoodstuffApi foodstuffApi;
    @Override
    @GlobalTransactional
    public List<CuisineVO> selectCuisineAllInfo() {
        List<CuisineDO> cuisineDos = cuisineMapper.selectList(null);
        // 口味ID与名称的map
        HashMap<Integer, String> flavourMap = selectFlavourByIds(cuisineDos.stream().map(CuisineDO::getFlavourId).collect(Collectors.toList()));
        return new ArrayList<>() {{
            // 将DO转换为VO
            cuisineDos.forEach(c -> add(new CuisineVO(c.getCuisineName(), flavourMap.get(c.getFlavourId()), c.getDuration(), c.getPrice(), c.getRemarks(), null, null)));
        }};
    }

    @Override
    public String selectFlavourById(Integer flavourId) {
        return flavourMapper.selectById(flavourId).getFlavourName();
    }

    @Override
    public HashMap<Integer, String> selectFlavourByIds(List<Integer> flavourIds) {
        return (HashMap<Integer, String>) flavourMapper.selectList(
                new LambdaQueryWrapper<FlavourDO>().in(FlavourDO::getFlavourId, flavourIds)
        ).stream().collect(Collectors.toMap(FlavourDO::getFlavourId, FlavourDO::getFlavourName));
    }

    @Override
    public HashMap<Integer, String> selectCuisineByIds(List<Integer> cuisineIds) {
        return (HashMap<Integer, String>) cuisineMapper.selectList(
                new LambdaQueryWrapper<CuisineDO>().in(CuisineDO::getCuisineId, cuisineIds)
        ).stream().collect(Collectors.toMap(CuisineDO::getCuisineId, CuisineDO::getCuisineName));
    }

    @Override
    public Page<CuisineDO> selectCuisineByNames(String cuisineName, Integer pageNo, Integer pageSize) {
        Page<CuisineDO> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(pageSize);
        LambdaQueryWrapper<CuisineDO> like = new LambdaQueryWrapper<CuisineDO>().like(CuisineDO::getCuisineName, cuisineName);

        return cuisineMapper.selectPage(page, like);
    }

    @Override
    public List<CuisineVO> selectCuisineByFlavour(String flavourName) {
        List<FlavourDO> flavourDos = flavourMapper.selectByMap(new HashMap<>(1) {{
            put("flavour_name", flavourName);
        }});
        List<Integer> flavourIds = flavourDos.stream().map(FlavourDO::getFlavourId).collect(Collectors.toList());
        Map<Integer, String> flavourMap = flavourDos.stream().collect(Collectors.toMap(FlavourDO::getFlavourId, FlavourDO::getFlavourName));
        List<CuisineDO> cuisineDos = cuisineMapper.selectList(
                new LambdaQueryWrapper<CuisineDO>().in(CuisineDO::getFlavourId, flavourIds)
        );

        return new ArrayList<>() {{
            cuisineDos.forEach(c -> add(new CuisineVO(c.getCuisineName(), flavourMap.get(c.getFlavourId()), c.getDuration(), c.getPrice(), c.getRemarks(), null, null)));
        }};
    }

    @Override
    public List<CuisineVO> selectCuisineByFoddstuff(List<String> foodstuffNames) {
        List<Integer> foodstuffIds = foodstuffApi.selectByFoodstuffNames(foodstuffNames).stream().map(FoodstuffDO::getFoodstuffId).collect(Collectors.toList());
        List<Integer> cuisineIds = relationshipMapper.selectList(
                new LambdaQueryWrapper<RelationshipDO>().in(RelationshipDO::getFoodstuffId, foodstuffIds).groupBy(RelationshipDO::getCuisineId)
        ).stream().map(RelationshipDO::getCuisineId).collect(Collectors.toList());
        List<CuisineDO> cuisineDos = cuisineMapper.selectList(
                new LambdaQueryWrapper<CuisineDO>().in(CuisineDO::getCuisineId, cuisineIds)
        );
        HashMap<Integer, String> flavourMap = selectFlavourByIds(cuisineDos.stream().map(CuisineDO::getFlavourId).collect(Collectors.toList()));
        return new ArrayList<>() {{
            // 将DO转换为VO
            cuisineDos.forEach(c -> add(new CuisineVO(c.getCuisineName(), flavourMap.get(c.getFlavourId()), c.getDuration(), c.getPrice(), c.getRemarks(), null, null)));
        }};
    }
}