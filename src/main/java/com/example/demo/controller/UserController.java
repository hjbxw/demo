package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user/editUser",method = RequestMethod.POST)
    public Boolean editUser(User user){
        int i = userService.updateUser(user);
        Boolean b = false;
        if (1>0){
            b =true;
        }
        return b;
    }

    @ResponseBody
    @RequestMapping(value = "/user/editPwd",method = RequestMethod.POST)
    public Boolean editPwd(User user){
        Boolean b = userService.editPwd(user);
        return b;
    }

    @ResponseBody
    @RequestMapping(value = "/user/findByName",method = RequestMethod.POST)
    public User ifhave(User onylusername){
        User user2 = userService.findByName(onylusername.getUsername());
        return user2;
    }

    @GetMapping("/userInf/setpwd")
    public String toSetPwd(){
        return "setpwd";
    }
}
