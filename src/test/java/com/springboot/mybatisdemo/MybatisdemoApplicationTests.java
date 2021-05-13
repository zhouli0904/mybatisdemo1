package com.springboot.mybatisdemo;

import com.springboot.mybatisdemo.Controller.StudentController;
import com.springboot.mybatisdemo.dao.test.StudentMapper;
import com.springboot.mybatisdemo.dao.zl.TOrderMapper;
import com.springboot.mybatisdemo.entity.test.Student;
import com.springboot.mybatisdemo.entity.zl.TOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MybatisdemoApplication.class)
class MybatisdemoApplicationTests {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TOrderMapper tOrderMapper;
    @Autowired
    StudentController studentController;

    @Test
    void contextLoads() {
        Student student = studentMapper.selectByPrimaryKey(2);
        System.out.println(student);
    }

    @Test
    void test2(){
        Object delete = studentController.delete(5);
        System.out.println(delete);
    }

    /**
     * 获取自增主键的值
     */
    @Test
    void test3(){
        Student s = new Student(null, "json", 20, "guangzhou", "12345");
        Object insert = studentMapper.insert(s);
        System.out.println(s.getId());
    }

    @Test
    void test4(){
        TOrder tOrder = tOrderMapper.selectByPrimaryKey(1);
        System.out.println(tOrder);
    }

}
