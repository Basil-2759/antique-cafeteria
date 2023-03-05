package com.basil;

import com.basil.mapper.CuisineMapper;
import com.basil.table.TbCuisine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Basil
 * @create 2023/3/4 16:05
 * @description 测试类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CuisineAppTest {
    @Autowired
    private CuisineMapper cuisineMapper;

    @Test
    public void contextLoads() {
        List<TbCuisine> list = cuisineMapper.selectList(null);
        list.forEach(System.out::println);
    }
}
