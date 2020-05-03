package com.example.demo.mapper;

import com.example.demo.model.User;
import com.example.demo.model.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoMapper {
    //    查找视频
    public List<Video> findVideo(Integer pageNun,Integer pageSize,String title);

    //    查找所有视频
    public List<Video> findAllVideo();

    //    添加视频
    public int inserVideo(Video video);

    //    删除视频
    public int deleteVideo(String vid);

    //    编辑信息
    public int updateVideo(Video video);

    //   增加播放量
    public int incLook(String vid, Integer looknum);

    //   点赞
    public int incgood(String vid, Integer goodnum);

    //根据id查询
    public Video findVideoById(String vid);

    //查询最新视频
    public List<Video> findNewVideo();

    //查询最新视频
    public List<Video> findZrVideo();

    /*更新审核状态*/
    public void updateShenHe(String state, String btgyy,String vid);

}
