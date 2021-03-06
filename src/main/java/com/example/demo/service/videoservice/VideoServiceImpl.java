package com.example.demo.service.videoservice;

import com.example.demo.mapper.VideoMapper;
import com.example.demo.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<Video> findVideo(Integer pageNum, Integer pageSize, String title) {
        return videoMapper.findVideo(pageNum,pageSize,title);
    }

    @Override
    public List<Video> findAllVideo() {
        return videoMapper.findAllVideo();
    }

    @Override
    public int inserVideo(Video video) {
        return videoMapper.inserVideo(video);
    }

    @Override
    public int deleteVideo(String vid) {
        return videoMapper.deleteVideo(vid);
    }

    @Override
    public int updateVideo(Video video) {
        return videoMapper.updateVideo(video);
    }

    @Override
    public int incLook(String vid, Integer looknum) {
        return videoMapper.incLook(vid, looknum);
    }

    @Override
    public int incgood(String vid, Integer goodnum) {
        return videoMapper.incgood(vid, goodnum);
    }

    @Override
    public Video findVideoById(String vid) {
        return videoMapper.findVideoById(vid);
    }

    @Override
    public List<Video> findNewVideo() {
        return videoMapper.findNewVideo();
    }

    @Override
    public List<Video> findZrVideo() {
        return videoMapper.findZrVideo();
    }

    @Override
    public void updateShenHe(String state, String btgyy,String vid) {
        if (btgyy==null)
            btgyy="审核通过";
        videoMapper.updateShenHe(state,btgyy,vid);
    }

    @Override
    public List<Video> findNewVideoPage(Integer pageNum, Integer pageSize) {
        return videoMapper.findNewVideoPage(pageNum,pageSize);
    }

    @Override
    public List<Video> findZrVideoPage(Integer pageNum, Integer pageSize) {
        return videoMapper.findZrVideoPage(pageNum,pageSize);
    }

    @Override
    public List<Video> findScAll(Integer pageNum, Integer pageSize, String userid) {
        return videoMapper.findScAll(pageNum, pageSize, userid);
    }

    @Override
    public List<Video> findVideoByFq(Integer pageNum, Integer pageSize, String fq) {
        return videoMapper.findVideoByFq(pageNum, pageSize, fq);
    }
}
