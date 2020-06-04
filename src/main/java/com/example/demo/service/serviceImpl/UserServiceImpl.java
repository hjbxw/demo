package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.service.UserService;
import com.example.demo.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserMapper userMapper;

    //用户登录
    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    //用户注册
    @Override
    public int regUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user)  {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date day=null;
        try {
             day = format.parse(user.getBirthday());
        }catch (ParseException e){
            e.printStackTrace();
        }

        String birthday = MyStringUtils.getAgeByBirth(day);
        user.setBirthday(birthday);
        return userMapper.updateUser(user);
    }

    @Override
    public List<Video> findMyVideo(String id) {
        return userMapper.findMyVideo(id);
    }

    @Override
    public List<User> findAllUser(Integer pageNum,Integer pageSize) {
        return userMapper.findAllUser(pageNum,pageSize);
    }

    @Override
    public List<Video> findMyVideoPage(Integer pageNum, Integer pageSize, String id) {
        return userMapper.findMyVideoPage(pageNum, pageSize, id);
    }

    @Override
    public void deleteUser(String id) {
         userMapper.deleteUser(id);
    }

    @Override
    public List<User> findUserByName(Integer pageNum, Integer pageSize, String username) {
        return userMapper.findUserByName(pageNum,pageSize,username);
    }

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public Boolean editPwd(User user) {
        return userMapper.editPwd(user);
    }

    @Override
    public Boolean editHeadPic(String id, String headpic) {
        return userMapper.editHeadPic(id, headpic);
    }
}
