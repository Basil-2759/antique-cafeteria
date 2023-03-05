package com.basil.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.basil.table.TbOrder;
import org.springframework.stereotype.Repository;

/**
 * @author Basil
 * @create 2023/3/5 8:36
 * @description com.basil.mapper antique-cafeteria
 */
@Repository
public interface OrderMapper extends BaseMapper<TbOrder> {
}
