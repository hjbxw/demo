package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Code;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.CodeRandom;
import com.sun.mail.smtp.SMTPAddressFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MailYanzController {

    @Autowired
    UserService userService;
    @Autowired
    private JavaMailSender mailSender;
    /*根据id查找用户*/

    @ResponseBody
    @RequestMapping(value = "/user/grzxFindUser",method = RequestMethod.POST)
    public User findUserById(@RequestParam String id){
        User user = userService.findUserById(id);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/toMail/sendMail",method = RequestMethod.POST)
    public Code sendEmail(@RequestParam String id,
                            @RequestParam String email, HttpSession session){
        User byfind = userService.findUserById(id);
        Code code = new Code();
        String codenum = CodeRandom.getCodeRandom();
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("1633367715@qq.com");
            message.setTo(email);
            message.setSubject("主题：修改用户名与密码");
            message.setText("尊敬的漫集结用户："+byfind.getUsername()+""
                    +
                    "，您的修改码为："+codenum);
           /* mailSender.send(message);*/
            code.setCode(codenum);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发送邮件失败");
        }
        return code;
    }


}
