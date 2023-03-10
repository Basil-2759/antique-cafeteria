package com.basil.api;

import com.basil.DAO.OrderHistoryDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Basil
 * @create 2023/3/5 15:23
 * @description com.basil antique-cafeteria
 */
@FeignClient(value = "order-history", path = "order_history")
public interface OrderHistoryApi {
    /**
     * @description 查询所有订单信息，无条件
     * @return 列表类型 OrderHistory
     */
    @GetMapping("select/order_history/all")
    List<OrderHistoryDO> selectAllInfo();
}
