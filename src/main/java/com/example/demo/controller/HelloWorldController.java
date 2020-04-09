package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloWorldController {

/*    @Autowired
    UserMapper userMapper;

    public User findUser(String id){
        User user=userMapper.findUserById(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        List<String> users=new ArrayList<>();
        users.add("zhangsan");
        users.add("lisi");
        users.add("wangwu");
        map.put("users",users);
        return  "success";
    }*/
}
