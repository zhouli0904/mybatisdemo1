package com.springboot.mybatisdemo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.mybatisdemo.dao.zl.TOrderMapper;
import com.springboot.mybatisdemo.entity.zl.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    TOrderMapper tOrderMapper;

    @RequestMapping("/select")
    public Object selectById(@RequestParam Integer id){
        JSONObject json = new JSONObject();
        TOrder tOrder = tOrderMapper.selectByPrimaryKey(id);
        json.put("code", 0);
        json.put("msg", "插入成功");
        return json;
    }
}
