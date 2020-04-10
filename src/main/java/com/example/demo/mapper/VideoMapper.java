package com.example.demo.mapper;

import com.example.demo.model.User;
import com.example.demo.model.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VideoMapper {
//    查找视频
    public Video findVideo(String title);
//    查找所有视频
    public Video findAllVideo();
//    添加视频
    public int inserVideo(Video video);
//    删除视频
    public int deleteVideo(String vid);
//    编辑信息
    public int updateVideo(Video video);
//   增加播放量
    public int incLook(String vid);
//   点赞
    public int incgood(String vid);
}