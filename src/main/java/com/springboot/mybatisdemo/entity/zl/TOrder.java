package com.springboot.mybatisdemo.entity.zl;

import lombok.Data;

import java.io.Serializable;

@Data
public class TOrder implements Serializable {
    private Integer id;

    private String orderId;

    private Double price;

    public String userName;

    private static final long serialVersionUID = 1L;

}