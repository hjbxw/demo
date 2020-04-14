package com.example.demo.mapper;

import com.example.demo.model.User;
import com.example.demo.model.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
//    查找用户
    public User findUserById(String id);

    public User userLogin(User user);
//    添加用户
    public int insertUser(User user);
//    删除用户
    public void deleteUser(String id);
//    编辑用户信息
    public int updateUser(User user);

    //查询个人视频
    public List<Video> findMyVideo(String id);
}
