package com.example.demo.controller.videocontroller;

import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.service.UserService;
import com.example.demo.service.videoservice.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class VideoController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(VideoController.class);

    @Autowired
    VideoService videoService;
    @Autowired
    private RedisTemplate redisTemplate;

    private ValueOperations<String, User> operations = null;

    private String url;

    @ResponseBody
    @RequestMapping(value = "/video/upvideo")
    public String upVideo(Video video,
                          MultipartFile[] files, HttpSession session) {
        logger.debug("上传文件===");
        //判断文件是否为空
        if (files==null) {
            return "上传文件不可为空";
        }
        String path=null;
        String srcfile=null;
        String picsrc=null;
        for (MultipartFile file :files) {
            /*获取文件名称后后缀*/

            String fileName = file.getOriginalFilename();
            String fileType=fileName.substring( fileName.lastIndexOf("."));
            if (".jpg".equals(fileType) || ".png".equals(fileType)){
                 picsrc= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
                 path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
                //创建文件路径
                File dest = new File(path);
                //判断文件是否已经存在
                if (dest.exists()) {
                    return "文件已经存在";
                }
                //判断文件父目录是否存在
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdir();
                }
                try {
                    //上传文件
                    file.transferTo(dest);
                } catch (IOException e) {
                    return "上传失败";
                }
            }else if (".mp4".equals(fileType)){
                 srcfile= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
                path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
                //创建文件路径
                File dest = new File(path);
                //判断文件是否已经存在
                if (dest.exists()) {
                    return "文件已经存在";
                }
                //判断文件父目录是否存在
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdir();
                }
                try {
                    //上传文件
                    file.transferTo(dest);
                } catch (IOException e) {
                    return "上传失败";
                }
            }
        }
        video.setVid(UUID.randomUUID().toString().replace("-", ""));
        video.setUptime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        video.setVsrc(srcfile);
        video.setPicsrc(picsrc);
        video.setLooknum(0);
        int jieguo = videoService.inserVideo(video);
        String key =  "myVideoList";
        List<Video>  myVideoList = (List<Video>)redisTemplate.opsForList().rightPop("myVideoList");
        boolean flag=redisTemplate.hasKey(key);
        if (flag){
            myVideoList.add(video);
            redisTemplate.opsForList().leftPush("myVideoList",myVideoList);
        }
        //加个时间戳，尽量避免文件名称重复
        /*String path = "E:/fileUpload/" + fileName;*/
        session.setAttribute("upvideo",video);
        return "ok";
    }


    @GetMapping("/video/wacth")
    public String wacthVideo(String vid,HttpSession session){
        Video video=videoService.findVideoById(vid);
        /*播放加1*/
        Integer looknum=video.getLooknum()+1;
        video.setLooknum(looknum);
        videoService.incLook(video.getVid(),looknum);
        if (!StringUtils.isEmpty(video)){
            session.setAttribute("video",video);
        }
        return "/video/wacth.html";
    }

}
