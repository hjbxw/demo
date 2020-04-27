package com.example.demo.controller.htglcontroller;

import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.service.UserService;
import com.example.demo.service.commentservice.CommentSayingService;
import com.example.demo.service.commentservice.CommentService;
import com.example.demo.service.videoservice.VideoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "/houtai/getAdmin/{pageNum}/{pageSize}")
    public PageInfo<User> getAdmin(@PathVariable( value = "pageNum") Integer pageNum,
                               @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> adminUser = new ArrayList<>();
        List<User> users=userService.findAllUser(pageNum,pageSize);
        for (int i=0;i<users.size();i++){
            if ("1".equals(users.get(i).getPower())){
                adminUser.add(users.get(i));
            }
        }
        PageInfo<User> adminPageInfo = new PageInfo<>(adminUser,10);
        return adminPageInfo;
    }
    /*查找非管理员用户*/
    @RequestMapping(value = "/houtai/getAllUser/{pageNum}/{pageSize}")
    public PageInfo<User> getAllUser(@PathVariable( value = "pageNum") Integer pageNum,
                                     @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> ptUsers = new ArrayList<>();
        List<User> users=userService.findAllUser(pageNum,pageSize);
        PageInfo<User> ptUserPageInfo = new PageInfo<>(users,10);
        return ptUserPageInfo;
    }
    @RequestMapping("/houtai/deleteUser/{userid}")
    public void delete(@PathVariable(value="userid") String userid) {
        userService.deleteUser(userid);
    }

    /**@
     * 查询所有视频
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/houtai/getAllVideo/{pageNum}/{pageSize}")
    public PageInfo<Video> getAllVideo(@PathVariable( value = "pageNum") Integer pageNum,
                                       @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList=videoService.findAllVideo();
        PageInfo<Video> videoPageInfo=new PageInfo<>(videoList,10);
        return videoPageInfo;
    }

}
