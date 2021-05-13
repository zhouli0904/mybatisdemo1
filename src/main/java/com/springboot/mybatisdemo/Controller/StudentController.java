package com.springboot.mybatisdemo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.mybatisdemo.dao.test.StudentMapper;
import com.springboot.mybatisdemo.entity.test.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentdemo")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

//    @GetMapping("/getAll")
//    public Object getAllStudent(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
//
//        if (pageNo == null || pageNo <= 0) {
//            pageNo = 1;
//        }
//        if (pageSize == null || pageSize <= 0 || pageSize > 100) {
//            pageSize = 10;
//        }
//        int start = (pageNo - 1) * pageSize;
//        return studentMapper.selectAll(start, pageSize);
//    }

    @GetMapping("/update")
    public Object update(@RequestParam("id") Integer id,
                         @RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "age", required = false) Integer age,
                         @RequestParam(value = "city", required = false) String city) {
        JSONObject json = new JSONObject();
        if (id == null || id <= 0) {
            json.put("code", 1);
            json.put("message", "id只能是正整数");
            return json;
        }
        if (age != null && age <=0) {
            json.put("code", 1);
            json.put("message", "age只能是正整数");
            return json;
        }

        Student old = studentMapper.selectByPrimaryKey(id);
        if (old == null) {
            json.put("code", 1);
            json.put("message", "原用户不存在");
            return json;
        }

        if (StringUtils.hasText(name)) {
            old.setName(name);
        }
        if (age != null) {
            old.setAge(age);
        }
        if (StringUtils.hasText(city)) {
            old.setCity(city);
        }
        studentMapper.updateByPrimaryKeySelective(old);
        json.put("code", 0);
        json.put("message", "修改成功");
        return json;

    }



    @PostMapping("/add")
    public Object add(@RequestBody Student student) {
        JSONObject json = new JSONObject();
        studentMapper.insertSelective(student);
        json.put("code", 0);
        json.put("message", "新增成功");
        return json;
    }



    @GetMapping("/delete")
    public Object delete(@RequestParam("id") Integer id) {
        JSONObject json = new JSONObject();
        if (id == null || id <= 0) {
            json.put("code", 1);
            json.put("message", "id只能是正整数");
            return json;
        }

        Student old = studentMapper.selectByPrimaryKey(id);
        if (old == null) {
            json.put("code", 1);
            json.put("message", "原用户不存在");
            return json;
        }
        studentMapper.deleteByPrimaryKey(id);
        json.put("code", 0);
        json.put("message", "删除成功");
        return json;
    }

    @GetMapping("/selectName")
    public Object selectName(@RequestParam("name") String name){
        JSONObject json = new JSONObject();
        List<Student> students = studentMapper.selectByName(name);
        if (students.size() == 0){
            json.put("code", 1);
            json.put("message", "原用户不存在");
            return json;
        }
        return students;

    }

}
