package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.service.UserService;
import com.example.demo.service.tieziservice.ArticleService;
import com.example.demo.service.videoservice.VideoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    VideoService videoService;

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

    @GetMapping("/userInf/otheruser")
    public String toFindOther(String id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("otheruser",user);
        PageHelper.startPage(1, 10);
        /*视频*/
        List<Video> videoList =userService.findMyVideoPage(1, 10, id);
        PageInfo<Video> videoPageInfo = new PageInfo<>(videoList, 10);
        model.addAttribute("videoPageInfo",videoPageInfo);
        /*帖子*/
        List<Article> articleList = articleService.findArByUserId(id,1,10);
        PageInfo<Article> articlePageInfo = new PageInfo<>(articleList, 10);
        model.addAttribute("articlePageInfo",articlePageInfo);
        return "otheruserInfo.html";
    }

    @GetMapping(value = "/userInf/gztofind/{id}")
    public String toFindOther2(@PathVariable String id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("otheruser",user);
        PageHelper.startPage(1, 10);
        /*视频*/
        List<Video> videoList =userService.findMyVideoPage(1, 10, id);
        PageInfo<Video> videoPageInfo = new PageInfo<>(videoList, 10);
        model.addAttribute("videoPageInfo",videoPageInfo);
        /*帖子*/
        List<Article> articleList = articleService.findArByUserId(id,1,10);
        PageInfo<Article> articlePageInfo = new PageInfo<>(articleList, 10);
        model.addAttribute("articlePageInfo",articlePageInfo);
        return "otheruserInfo.html";
    }

    @ResponseBody
    @RequestMapping(value = "/user/editTx",method = RequestMethod.POST)
    public Map uppic(@RequestParam(value = "file", required = false) MultipartFile file,
                     @RequestParam (value = "id") String id,
                     HttpSession session) {
        Map resmap = new HashMap();
        String path =null;
        String picsrc = file.getOriginalFilename();
        path = "E:/fileUpload/headpic/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + picsrc;
        String url = "headpic/"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + picsrc;
        //创建文件路径
        File dest = new File(path);
        //判断文件是否已经存在
        if (dest.exists()) {
            resmap.put("success", 0);
            return resmap;
        }
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //上传文件
            userService.editHeadPic(id,url);
            User loginUser = userService.findUserById(id);
            session.setAttribute("loginUser",loginUser);
            file.transferTo(dest);
            resmap.put("success", 1);
            resmap.put("message", "上传成功");
        } catch (IOException e) {
            resmap.put("success", 0);
            return resmap;
        }
        return resmap;
    }
}
