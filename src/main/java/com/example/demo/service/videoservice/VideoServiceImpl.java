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
    public List<Video> findVideo(String title) {
        return videoMapper.findVideo(title);
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
}
