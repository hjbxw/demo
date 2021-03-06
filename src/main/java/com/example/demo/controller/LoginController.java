package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    private ValueOperations<String, User> operations = null;

    //    登录方法
    @PostMapping(value = "/user/login")
    public String login(User user,
                        Map<String, Object> msgMap,
                        HttpSession session) {
        User loginUser = userService.userLogin(user);
        operations = redisTemplate.opsForValue();
        if (!StringUtils.isEmpty(loginUser) && user.getUsername().equals(loginUser.getUsername())) {
            session.setAttribute("loginUser", loginUser);
            String key = "user-" + loginUser.getId();
            /*将登录成功的用户信息存入readis*/
            operations.set(key, loginUser, 3, TimeUnit.HOURS);
            if ("1".equals(loginUser.getPower())) {
                if (!"0".equals(loginUser.getState())) {
                    return "/houtai/houtai.html";
                } else {
                    session.setAttribute("msg", "你已被禁止进入本网站");
                    return "login";
                }
            } else {
                if (!"0".equals(loginUser.getState())) {
                    return "redirect:/main.html";
                } else {
                    session.setAttribute("msg", "你已被禁止进入本网站");
                    return "login";
                }
            }
        } else {
            session.setAttribute("msg", "登陆失败，请检查用户名或密码");
            return "login";
        }

    }

    @GetMapping("/user/toHome")
    public String toHome() {

        return "redirect:/main.html";
    }

    //注册方法
    @PostMapping("/user/register")
    public String register(User user,
                           Map<String, Object> msgMap) {
        int flag = 0;
        if (!StringUtils.isEmpty(user)) {
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setPower("2");
            user.setHeadpic("img/li.jpg");
            flag = userService.regUser(user);
        }
        if (flag > 0) {
            msgMap.put("msg", "恭喜您，注册成功，请登录！");
            return "redirect:/index.html";
        } else {
            msgMap.put("msg", "注册失败");
            return "register";
        }
    }

    //退出
    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        session.invalidate();
        return "login";
    }

    //跳转到个人中心
    @GetMapping("/user/perInfo")
    public String perInfo(String id, HttpSession session) {
        User userByFind = userService.findUserById(id);
        session.setAttribute("userByFind", userByFind);
        return "userInfo.html";
    }

    @GetMapping("/luntan/toLuntan")
    public String toLuntan(){
        return "/tiezi/articleIndex.html";
    }

/*    @GetMapping("/video/findMyVideo")
    public String findMyVideo(String id, HttpSession session) {
        *//*查询个人视频*//*
        List<Video> myVideoList = null;
        String key = "myVideoList";
        boolean flag = redisTemplate.hasKey(key);
        if (!flag) {

            myVideoList = userService.findMyVideo(id);
            if (!StringUtils.isEmpty(myVideoList))
                redisTemplate.opsForList().rightPush("myVideoList", myVideoList);
        } else {

            myVideoList = (List<Video>) redisTemplate.opsForList().rightPop("myVideoList");
        }
        session.setAttribute("myVideoList", myVideoList);
        return "userInfo :: myvideo";
    }*/

    /**
     * 编辑用户信息
     */

    @PostMapping("/user/editInfo")
    public String editInfo(User user, HttpSession session) {
        String key = user.getId();
        int flag = userService.updateUser(user);
        if (flag > 0) {
            operations.set(key, user, 3, TimeUnit.HOURS);
            session.setAttribute("userByFind", user);
            return "userinfo.html";
        } else {
            return null;
        }
    }

}
