package com.example.demo.service.videoservice;

import com.example.demo.model.Video;

public interface VideoService {
    //    查找视频
    public Video findVideo(String title);
    //    查找所有视频
    public Video findAllVideo();
    //    添加视频
    public int inserVideo(Video video);
    //    删除视频
    public int deleteVideo(String vid);
    //    编辑用户信息
    public int updateVideo(Video video);
    //   增加播放量
    public int incLook(String vid,Integer looknum);
    //   点赞
    public int incgood(String vid,Integer goodnum);
    //根据id查询
    public Video findVideoById(String vid);
}
