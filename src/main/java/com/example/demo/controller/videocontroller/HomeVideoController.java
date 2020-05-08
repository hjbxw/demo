package com.example.demo.controller.videocontroller;

import com.example.demo.model.CommentFirstLevel;
import com.example.demo.model.Video;
import com.example.demo.service.videoservice.VideoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

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

    /*最新视频*/


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

    @RequestMapping(value = "/video/showZrMore/{pageNum}/{pageSize}")
    public PageInfo<Video> showZrMore(@PathVariable( value = "pageNum") Integer pageNum,
                                      @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList=videoService.findZrVideoPage(pageNum,pageSize);
        PageInfo<Video> videozrMorePage=new PageInfo<>(videoList,10);
        return videozrMorePage;
    }


    @RequestMapping(value = "/video/showZxMore/{pageNum}/{pageSize}")
    public PageInfo<Video> showZxMore(@PathVariable( value = "pageNum") Integer pageNum,
                                      @PathVariable( value = "pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList=videoService.findNewVideoPage(pageNum,pageSize);
        PageInfo<Video> videozrMorePage=new PageInfo<>(videoList,10);
        return videozrMorePage;
    }


    @RequestMapping(value = "/video/getVideoByToz" , method = RequestMethod.POST)
    public PageInfo<Video> getVideoBtToz(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize
            ,@RequestParam String title){
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList=videoService.findVideo(pageNum,pageSize,title);
        PageInfo<Video> videoPageInfo=new PageInfo<>(videoList,10);
        return videoPageInfo;
    }
}
