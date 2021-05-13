package com.springboot.mybatisdemo.dao.zl;

import com.springboot.mybatisdemo.entity.zl.OrderInfo;

import java.util.List;

public interface OrderInfoMapper {

    int addInfo(List<OrderInfo> infos);

    List<OrderInfo> getInfoByConditionForEach(List<String> infos);

    List<OrderInfo> getInfoByConditionWhen(OrderInfo orderInfo);

    List<OrderInfo> getInfoByConditionIf(OrderInfo orderInfo);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}