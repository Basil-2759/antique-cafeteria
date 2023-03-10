package com.basil.service.serviceImpl;

import com.basil.DAO.CuisineDO;
import com.basil.VO.CuisineVO;
import com.basil.VO.OrderHistoryVO;
import com.basil.api.CuisineApi;
import com.basil.mapper.OrderHistoryMapper;
import com.basil.service.OrderHistoryService;
import com.basil.DAO.OrderHistoryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Basil
 * @create 2023/3/5 15:22
 * @description com.basil.service.serviceImpl antique-cafeteria
 */
@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    private OrderHistoryMapper orderHistoryMapper;

    @Autowired
    private CuisineApi cuisineApi;

    @Override
    public List<OrderHistoryVO> selectAllOrderInfo() {
        List<OrderHistoryDO> orderHistoryDos = orderHistoryMapper.selectList(null);
        // 菜肴ID与名称的map
        HashMap<Integer, String> cuisineMap = cuisineApi.selectCuisineByIds(orderHistoryDos.stream().map(OrderHistoryDO::getCuisineId).collect(Collectors.toList()));
        return new ArrayList<>(){{
            // 将DO转换为VO
            orderHistoryDos.forEach(c -> {
                add(new OrderHistoryVO(c.getOrderId(), cuisineMap.get(c.getCuisineId()), c.getCreateTime()));
            });
        }};
    }
}
