package com.springboot.mybatisdemo.entity.zl;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@Alias("o2")
public class OrderInfo2 implements Serializable {
    private String orderId;

    private String goodsList;

    private String address;

    private Integer state;

    private  TOrder tOrder;

    private static final long serialVersionUID = 1L;


}