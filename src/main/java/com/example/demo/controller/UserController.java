package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/user/editUser",method = RequestMethod.POST)
    public Boolean editUser(User user){
        int i = userService.updateUser(user);
        Boolean b = false;
        if (1>0){
            b =true;
        }
        return b;
    }
}
