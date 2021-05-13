package com.springboot.mybatisdemo;

import com.springboot.mybatisdemo.dao.zl.OrderInfoMapper;
import com.springboot.mybatisdemo.dao.zl.TOrderMapper;
import com.springboot.mybatisdemo.entity.zl.OrderInfo;
import com.springboot.mybatisdemo.entity.zl.OrderInfo2;
import com.springboot.mybatisdemo.entity.zl.TOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test02 {

    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    TOrderMapper tOrderMapper;

    @Test
    void test01(){
        OrderInfo2 tOderAndInfo = tOrderMapper.getTOderAndInfo("20200102");
        System.out.println(tOderAndInfo);
    }

}
