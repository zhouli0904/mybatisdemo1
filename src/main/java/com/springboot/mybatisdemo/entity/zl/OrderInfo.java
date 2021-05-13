package com.springboot.mybatisdemo.entity.zl;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrderInfo implements Serializable {
    private String orderId;

    private String goodsList;

    private String address;

    private Integer state;

    private static final long serialVersionUID = 1L;


}