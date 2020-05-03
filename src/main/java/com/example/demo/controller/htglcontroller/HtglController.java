package com.example.demo.controller.htglcontroller;

import com.example.demo.model.*;
import com.example.demo.service.UserService;
import com.example.demo.service.commentservice.CommentSayingService;
import com.example.demo.service.commentservice.CommentService;
import com.example.demo.service.videoservice.VideoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    /*查找非管理员用户ByUsername*/
    @RequestMapping(value = "/houtai/getUserByName")
    public PageInfo<User> getUserByName(@RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize,
                                        @RequestParam String username){
        PageHelper.startPage(pageNum, pageSize);
        List<User> ptUsers = new ArrayList<>();
        List<User> users=userService.findUserByName(pageNum,pageSize,username);
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

    /**@
     * 根据标题或者作者名称查询视频
     * @param pageNum
     * @param pageSize
     * @param title
     * @return 视频集合
     */
    @RequestMapping(value = "/houtai/getVideoByToz" , method = RequestMethod.POST)
    public PageInfo<Video> getVideoBtToz(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize
                                          ,@RequestParam String title){
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList=videoService.findVideo(pageNum,pageSize,title);
        PageInfo<Video> videoPageInfo=new PageInfo<>(videoList,10);
        return videoPageInfo;
    }

    /**@
     * 修改视频状态
     * @param editvideo
     * @return
     */
    @RequestMapping(value = "/houtai/editVideoState",method = RequestMethod.POST)
    public String editVideoState(Video editvideo){
        videoService.updateShenHe(editvideo.getState(),editvideo.getBtgyy(),editvideo.getVid());
        return "ok";
    }

    /**@
     * 修改管理员状态
     * @param editadmin
     * @return
     */
    @RequestMapping(value = "/houtai/editAdmin",method = RequestMethod.POST)
    public String editAdmin(User editadmin){
        userService.updateUser(editadmin);
        return "ok";
    }

    /**@
     * 添加管理员
     * @param addadmin
     * @return
     */
    @RequestMapping(value = "/houtai/addAdmin",method = RequestMethod.POST)
    public String addAdmin(User addadmin){
        addadmin.setId(UUID.randomUUID().toString().replace("-", ""));
        userService.regUser(addadmin);
        return "ok";
    }

    /**@
     * 查询一级评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/houtai/getComment/{pageNum}/{pageSize}")
    public PageInfo<CommentSaying> getComment(@PathVariable( value = "pageNum") Integer pageNum,
                                          @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<CommentSaying> commentList=commentSayingService.selectCommentAll(pageNum,pageSize);
        PageInfo<CommentSaying> videoPageInfo=new PageInfo<>(commentList,10);
        return videoPageInfo;
    }
    @RequestMapping(value = "/houtai/getComment2")
    public PageInfo<CommentSaying> getComment2(@RequestParam Integer pageNum,
                                               @RequestParam Integer pageSize,
                                               @RequestParam String sayingContent){
        PageHelper.startPage(pageNum, pageSize);
        List<CommentSaying> commentList=commentSayingService.selectSayBy(pageNum,pageSize,sayingContent);
        PageInfo<CommentSaying> videoPageInfo=new PageInfo<>(commentList,10);
        return videoPageInfo;
    }

    @RequestMapping(value = "/houtai/getCommentErji/{pageNum}/{pageSize}")
    public PageInfo<CommentFirstLevel> getCommentErji(@PathVariable( value = "pageNum") Integer pageNum,
                                                      @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<CommentFirstLevel> commentList=commentService.selectFlcAll(pageNum,pageSize);
        PageInfo<CommentFirstLevel> videoejPageInfo=new PageInfo<>(commentList,10);
        return videoejPageInfo;
    }

    @RequestMapping(value = "/houtai/getCommentErji2")
    public PageInfo<CommentFirstLevel> getCommentErji2(@RequestParam Integer pageNum,
                                                      @RequestParam Integer pageSize,
                                                      @RequestParam String sayingContent){
        PageHelper.startPage(pageNum, pageSize);
        List<CommentFirstLevel> commentList=commentService.selectFlBy(pageNum,pageSize,sayingContent);
        PageInfo<CommentFirstLevel> videoejPageInfo=new PageInfo<>(commentList,10);
        return videoejPageInfo;
    }

    @RequestMapping(value = "/houtai/getCommentShanji/{pageNum}/{pageSize}")
    public PageInfo<CommentSecondLevel> getCommentShanji(@PathVariable( value = "pageNum") Integer pageNum,
                                                      @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<CommentSecondLevel> commentList=commentService.selectSlcAll(pageNum,pageSize);
        PageInfo<CommentSecondLevel> videosjPageInfo=new PageInfo<>(commentList,10);
        return videosjPageInfo;
    }

    @RequestMapping(value = "/houtai/getCommentShanji2")
    public PageInfo<CommentSecondLevel> getCommentShanji2(@RequestParam Integer pageNum,
                                                         @RequestParam Integer pageSize,
                                                         @RequestParam String sayingContent){
        PageHelper.startPage(pageNum, pageSize);
        List<CommentSecondLevel> commentList=commentService.selectSlBy(pageNum,pageSize,sayingContent);
        PageInfo<CommentSecondLevel> videosjPageInfo=new PageInfo<>(commentList,10);
        return videosjPageInfo;
    }

    @RequestMapping(value = "/houtai/delPl/{id}")
    public void delComment(@PathVariable String id){
        commentService.removeFlcComment(id,id);
        commentService.removeSlcComment(id,id);
    }
    @RequestMapping(value = "/houtai/delPls/{id}")
    public void delPls(@PathVariable String id){
        commentSayingService.deleteById(id);
        commentService.removeFlcComment(id,id);
        commentService.removeSlcComment(id,id);
    }
}
