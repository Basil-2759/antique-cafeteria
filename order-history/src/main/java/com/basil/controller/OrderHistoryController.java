package com.basil.controller;

import com.basil.VO.OrderHistoryVO;
import com.basil.service.OrderHistoryService;
import com.basil.DAO.OrderHistoryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Basil
 * @create 2023/3/5 15:20
 * @description com.basil.controller antique-cafeteria
 */
@RestController
@RequestMapping("order_history")
@RefreshScope
public class OrderHistoryController {
    @Autowired
    private OrderHistoryService orderHistoryService;

    @GetMapping("select/order_history/all")
    public List<OrderHistoryVO> selectAllInfo() {
        return orderHistoryService.selectAllOrderInfo();
    }
}
