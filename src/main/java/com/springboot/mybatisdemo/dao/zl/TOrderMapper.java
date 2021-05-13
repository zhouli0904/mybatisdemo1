package com.springboot.mybatisdemo.dao.zl;

import com.springboot.mybatisdemo.entity.zl.OrderInfo2;
import com.springboot.mybatisdemo.entity.zl.TOrder;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface TOrderMapper {

    /**
     * 多个参数，是业务模型中的值，可以不写param
     * @param orderId
     * @param id
     * @return
     */
    TOrder selectByOrderIDAndId(@Param("orderId") String orderId, @Param("id") Integer id);
//    TOrder selectByOrderIDAndId(String orderId, Integer id);

    /**
     * 多个参数封装成map
     * @param map
     * @return
     */
    TOrder getByMap(Map<String, Object> map);

    /**
     * 传入的参数是对象
     * @param id
     * @param tOrder
     * @return
     */
    TOrder getOrder(Integer id, @Param("t") TOrder tOrder);

    /**
     * 参数是列表
     * @param ids
     * @return
     */
    TOrder getOrderById(List<Integer> ids);

    /**
     * 返回值是list
     * @param userName
     * @return
     */
    List<TOrder> getOrderByNameLike(String userName);

    /**
     * 返回一条记录的map，key是列名，值是对应的值
     * @param id
     * @return
     */
    Map<String, Object> getOrderByIdReturnMap(Integer id);

    /**
     * 多条记录封装一个map：Map<Integer, TOrder> Integer是这条记录的主键，值是封装后的
     * @param userName
     * @return
     */
    // 告诉mybatis封装这个map使用哪个键作为map主键
    @MapKey("id")
    Map<Integer, TOrder> getOrderByNameReturnMap(String userName);

    OrderInfo2 getTOderAndInfo(String orderId);

    TOrder getOrderByOrderId(String orderId);

    int deleteByPrimaryKey(Integer id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
}