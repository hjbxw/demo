package com.example.demo.controller.videocontroller;

import com.example.demo.model.User;
import com.example.demo.model.Video;
import com.example.demo.service.UserService;
import com.example.demo.service.videoservice.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
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
                          @RequestParam("file") MultipartFile file, HttpSession session) {
        logger.debug("上传文件===");
        //判断文件是否为空
        if (file.isEmpty()) {
            return "上传文件不可为空";
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        String srcfile= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"_"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        logger.debug("上传的文件名为: "+fileName);

        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        logger.debug("（加个时间戳，尽量避免文件名称重复）保存的文件名为: " + fileName);


        //加个时间戳，尽量避免文件名称重复
        /*String path = "E:/fileUpload/" + fileName;*/
        String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;

        //文件绝对路径
        logger.debug("绝对路径"+path);

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
            file.transferTo(dest); //保存文件
            //url="http://你自己的域名/项目名/images/"+fileName;//正式项目
            /*url = "http://localhost:8080/demo/" + fileName;//本地运行项目*/
            /*封装视频对象*/
            video.setVid(UUID.randomUUID().toString());
            video.setUptime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            video.setVsrc(srcfile);
            int jieguo = videoService.inserVideo(video);
            logger.debug("文件保存路径"+path);

            String key =  "myVideoList";
             List<Video>  myVideoList = (List<Video>)redisTemplate.opsForList().rightPop("myVideoList");
            boolean flag=redisTemplate.hasKey(key);
            if (flag){
                myVideoList.add(video);
                redisTemplate.opsForList().leftPush("myVideoList",myVideoList);
            }

        } catch (IOException e) {
            return "上传失败";
        }

        session.setAttribute("upvideo",video);
        return "success";
    }



}
