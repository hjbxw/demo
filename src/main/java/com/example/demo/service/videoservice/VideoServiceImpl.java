package com.example.demo.service.videoservice;

import com.example.demo.mapper.VideoMapper;
import com.example.demo.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    VideoMapper videoMapper;

    @Override
    public Video findVideo(String title) {
        return videoMapper.findVideo(title);
    }

    @Override
    public Video findAllVideo() {
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
    public int incLook(String vid) {
        return videoMapper.incLook(vid);
    }

    @Override
    public int incgood(String vid) {
        return videoMapper.incgood(vid);
    }
}
