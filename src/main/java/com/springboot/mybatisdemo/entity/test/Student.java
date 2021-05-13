package com.springboot.mybatisdemo.entity.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Student implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String city;

    private String mobilePhone;

    private static final long serialVersionUID = 1L;


}