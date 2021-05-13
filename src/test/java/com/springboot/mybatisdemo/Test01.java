package com.springboot.mybatisdemo;

import com.springboot.mybatisdemo.dao.zl.TOrderMapper;
import com.springboot.mybatisdemo.entity.zl.TOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = MybatisdemoApplication.class)
public class Test01 {

    @Autowired
    TOrderMapper tOrderMapper;

    @Test
    void test01(){
        TOrder tOrder = tOrderMapper.selectByOrderIDAndId("20200104", 2);
        System.out.println(tOrder);
    }

    @Test
    void test02(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        map.put("orderId", "20200104");
        TOrder byMap = tOrderMapper.getByMap(map);
        System.out.println(byMap);
    }

    @Test
    void test03(){
        TOrder tOrder = new TOrder();
        tOrder.setUserName("zl");
        TOrder order = tOrderMapper.getOrder(1, tOrder);
        System.out.println(order);
    }

    @Test
    void test04(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        TOrder orderById = tOrderMapper.getOrderById(list);
        System.out.println(orderById);
    }

    @Test
    void test05(){
        List<TOrder> like = tOrderMapper.getOrderByNameLike("%l%");
        for (TOrder tOrder : like) {
            System.out.println(tOrder);
        }
    }

    @Test
    void test06(){
        Map<String, Object> orderByIdReturnMap = tOrderMapper.getOrderByIdReturnMap(1);
        System.out.println(orderByIdReturnMap);
    }

    @Test
    void test07(){
        Map<Integer, TOrder> orderByNameReturnMap = tOrderMapper.getOrderByNameReturnMap("%u%");
        System.out.println(orderByNameReturnMap);
    }
}
