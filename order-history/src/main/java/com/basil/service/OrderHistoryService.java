package com.basil.service;

import com.basil.VO.OrderHistoryVO;

import java.util.List;

/**
 * @author Basil
 * @create 2023/3/5 15:20
 * @description com.basil.service antique-cafeteria
 */
public interface OrderHistoryService {
    /**
     * @description 查询所有订单信息，无条件
     * @return 列表类型 OrderHistory
     */
    List<OrderHistoryVO> selectAllOrderInfo();
}
