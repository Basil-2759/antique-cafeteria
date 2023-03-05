package com.basil.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.basil.table.TbCuisine;
import org.springframework.stereotype.Repository;

/**
 * @author Basil
 * @create 2023/3/4 15:44
 * @description 菜肴功能接口
 */
@Repository
public interface CuisineMapper extends BaseMapper<TbCuisine> {
}
