package com.example.demo.service.videoservice;

import com.example.demo.model.Video;

import java.util.List;

public interface VideoService {
    //    查找视频
    public List<Video> findVideo(Integer pageNum,Integer pageSize,String title);
    //    查找所有视频
    public List<Video> findAllVideo();
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

    //查询最新视频
    public List<Video> findNewVideo();
    public List<Video> findNewVideoPage(Integer pageNum,Integer pageSize);

    //查询最新视频
    public List<Video> findZrVideo();
    public List<Video> findZrVideoPage(Integer pageNum,Integer pageSize);
    //更新审核状态
    public void updateShenHe(String state,String btgyy,String vid);

    /*查询用户收藏的东西*/
    public List<Video> findScAll(Integer pageNum,Integer pageSize,String  userid);

}
