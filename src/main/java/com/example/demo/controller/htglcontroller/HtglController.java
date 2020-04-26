package com.example.demo.controller.htglcontroller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.commentservice.CommentSayingService;
import com.example.demo.service.commentservice.CommentService;
import com.example.demo.service.videoservice.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HtglController {
    @Autowired
    UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    VideoService videoService;
    @Autowired
    private CommentSayingService commentSayingService;

    /*查找管理员*/
    @RequestMapping(value = "/houtai/getAdmin")
    public List<User> getAdmin(){
        List<User> adminUser = new ArrayList<>();
        List<User> users=userService.findAllUser();
        for (int i=0;i<users.size();i++){
            if ("1".equals(users.get(i).getPower())){
                adminUser.add(users.get(i));
            }
        }
        return adminUser;
    }
    /*查找非管理员用户*/
    @RequestMapping(value = "/houtai/getAllUser")
    public List<User> getAllUser(){
        List<User> ptUsers = new ArrayList<>();
        List<User> users=userService.findAllUser();
        for (int i=0;i<users.size();i++){
            if ("2".equals(users.get(i).getPower())){
                ptUsers.add(users.get(i));
            }
        }
        return ptUsers;
    }
    @RequestMapping("/houtai/deleteUser/{userid}")
    public void delete(@PathVariable(value="userid") String userid) {
        userService.deleteUser(userid);
    }
}
