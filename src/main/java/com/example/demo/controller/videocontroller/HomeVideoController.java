package com.example.demo.controller.videocontroller;

import com.example.demo.model.Video;
import com.example.demo.service.videoservice.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeVideoController {
    @Autowired
    VideoService videoService;
    @Autowired
    private RedisTemplate redisTemplate;

    /*最新视频*/
    @RequestMapping("/video/getZx/")
    public List<Video> showZx(){
        List<Video> videoList=videoService.findNewVideo();
        List<Video> newVideoList=new ArrayList<>();
        if (videoList.size()>5){
        for (int i=0;i<6;i++){
            newVideoList.add(videoList.get(i));
        }
        return newVideoList;
        }
        else {
            return videoList;
        }
    }

    /*最热门视频*/
    @RequestMapping("/video/getZr/")
    public List<Video> showZr(){
        List<Video> videoList=videoService.findZrVideo();
        List<Video> zrVideoList=new ArrayList<>();
        if (videoList.size()>5){
            for (int i=0;i<6;i++){
                zrVideoList.add(videoList.get(i));
            }
            return zrVideoList;
        }
        else {
            return videoList;
        }
    }
}
