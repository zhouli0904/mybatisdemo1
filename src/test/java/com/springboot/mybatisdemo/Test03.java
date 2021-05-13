package com.springboot.mybatisdemo;

import com.springboot.mybatisdemo.dao.zl.OrderInfoMapper;
import com.springboot.mybatisdemo.entity.zl.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Test03 {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Test
    void test01(){
        OrderInfo orderInfo = new OrderInfo("20200102", null, null, 0);
        List<OrderInfo> infoByConditionIf = orderInfoMapper.getInfoByConditionIf(orderInfo);
        for (OrderInfo info : infoByConditionIf) {
            System.out.println(info);
        }
    }

    @Test
    void test02(){
        OrderInfo orderInfo = new OrderInfo(null, null, "河南", 9);
        List<OrderInfo> infoByConditionIf = orderInfoMapper.getInfoByConditionIf(orderInfo);
        for (OrderInfo info : infoByConditionIf) {
            System.out.println(info);
        }
    }

    @Test
    void test03(){
        OrderInfo orderInfo = new OrderInfo(null, null, null, null);
        List<OrderInfo> infoByConditionWhen = orderInfoMapper.getInfoByConditionWhen(orderInfo);
        for (OrderInfo info : infoByConditionWhen) {
            System.out.println(info);
        }
    }

    @Test
    void test04(){
        List<String> list = new ArrayList<>();
        list.add("20200102");
        list.add("20200103");
        List<OrderInfo> infoByConditionForEach = orderInfoMapper.getInfoByConditionForEach(list);
        for (OrderInfo byConditionForEach : infoByConditionForEach) {
            System.out.println(byConditionForEach);
        }
    }

    @Test
    void test05(){
        List<OrderInfo> list = new ArrayList<>();
        list.add(new OrderInfo("20200105", "1204", "北京路100号", 1));
        list.add(new OrderInfo("20200106", "1205", "乌鲁木齐路100号", 0));
        int i = orderInfoMapper.addInfo(list);
        System.out.println(i);
    }
}
