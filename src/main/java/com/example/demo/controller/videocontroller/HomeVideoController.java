package com.example.demo.controller.videocontroller;

import com.example.demo.mapper.DianZanMapper;
import com.example.demo.model.CommentFirstLevel;
import com.example.demo.model.User;
import com.example.demo.model.UserLikes;
import com.example.demo.model.Video;
import com.example.demo.service.UserService;
import com.example.demo.service.attentionservice.AttentionService;
import com.example.demo.service.diazanservice.DianZService;
import com.example.demo.service.tieziservice.ArticleService;
import com.example.demo.service.videoservice.VideoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeVideoController {
    @Autowired
    VideoService videoService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    DianZService dianZService;
    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;
    @Autowired
    AttentionService attentionService;
    /*最新视频*/
    @RequestMapping("/video/getZx/")
    public List<Video> showZx() {
        List<Video> videoList = videoService.findNewVideo();
        List<Video> newVideoList = new ArrayList<>();
        if (videoList.size() > 5) {
            for (int i = 0; i < 5; i++) {
                newVideoList.add(videoList.get(i));
            }
            return newVideoList;
        } else {
            return videoList;
        }
    }

    /*最新视频*/


    /*最热门视频*/
    @RequestMapping("/video/getZr/")
    public List<Video> showZr() {
        List<Video> videoList = videoService.findZrVideo();
        List<Video> zrVideoList = new ArrayList<>();
        if (videoList.size() > 5) {
            for (int i = 0; i < 5; i++) {
                zrVideoList.add(videoList.get(i));
            }
            return zrVideoList;
        } else {
            return videoList;
        }
    }

    @RequestMapping(value = "/video/showZrMore/{pageNum}/{pageSize}")
    public PageInfo<Video> showZrMore(@PathVariable(value = "pageNum") Integer pageNum,
                                      @PathVariable(value = "pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList = videoService.findZrVideoPage(pageNum, pageSize);
        PageInfo<Video> videozrMorePage = new PageInfo<>(videoList, 10);
        return videozrMorePage;
    }


    @RequestMapping(value = "/video/showZxMore/{pageNum}/{pageSize}")
    public PageInfo<Video> showZxMore(@PathVariable(value = "pageNum") Integer pageNum,
                                      @PathVariable(value = "pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList = videoService.findNewVideoPage(pageNum, pageSize);
        PageInfo<Video> videozrMorePage = new PageInfo<>(videoList, 10);
        return videozrMorePage;
    }


    @RequestMapping(value = "/video/getVideoByToz", method = RequestMethod.POST)
    public PageInfo<Video> getVideoBtToz(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize
            , @RequestParam String title) {
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList = videoService.findVideo(pageNum, pageSize, title);
        PageInfo<Video> videoPageInfo = new PageInfo<>(videoList, 10);
        return videoPageInfo;
    }

    @RequestMapping(value = "/dianz/findDz/", method = RequestMethod.POST)
    public Boolean findDz(@RequestParam String dzuserid,
                          @RequestParam String bdzuserid
            , @RequestParam String num) {
        Boolean flag = dianZService.findDianZ(dzuserid, bdzuserid);
        return flag;
    }

    @RequestMapping(value = "/dianz/incDianz/", method = RequestMethod.POST)
    public Boolean incDianz(@RequestParam String dzuserid,
                            @RequestParam String bdzuserid
            , @RequestParam String num,@RequestParam String type) {
        Boolean flag = dianZService.insertDianZ(dzuserid, bdzuserid);
        if (flag) {
            if (type.equals("sp")){
            videoService.incgood(bdzuserid, Integer.parseInt(num));
            }
            else articleService.incatrgood(bdzuserid,Integer.parseInt(num));
        }
        return flag;
    }

    @RequestMapping(value = "/dianz/delDianZ", method = RequestMethod.POST)
    public Boolean delDianZ(@RequestParam String dzuserid,
                            @RequestParam String bdzuserid
            , @RequestParam String num,@RequestParam String type) {
        Boolean flag = dianZService.deltDianZ(dzuserid, bdzuserid);
        if (flag) {
            if (type.equals("sp")){
            videoService.incgood(bdzuserid, Integer.parseInt(num));}
            else articleService.incatrgood(bdzuserid,Integer.parseInt(num));
        }
        return flag;
    }

    @RequestMapping(value = "/guanz/findGz", method = RequestMethod.POST)
    public PageInfo<UserLikes> findGz(@RequestParam Integer pageNum,
                                      @RequestParam Integer pageSize
            , @RequestParam String attid,@RequestParam String uid) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserLikes> userLikesList = attentionService.findGz(pageNum,pageSize,attid,uid);
        PageInfo<UserLikes> userLikesPageInfo = new PageInfo<>(userLikesList, 10);
        return userLikesPageInfo;
    }


    @RequestMapping(value = "/guanz/insertGz", method = RequestMethod.POST)
    public Boolean insertGz(UserLikes userLikes) {
        Boolean flag = attentionService.inserGz(userLikes);
        return flag;
    }

    @RequestMapping(value = "/user/findGzList", method = RequestMethod.POST)
    public PageInfo<User> find(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize
            , @RequestParam String uid) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList=attentionService.findGzList(pageNum, pageSize, uid);
        PageInfo<User> userPageInfo = new PageInfo<>(userList, 10);
        return userPageInfo;
    }

    @RequestMapping(value = "/guanz/delGz", method = RequestMethod.POST)
    public Boolean insertGz(@RequestParam String uid,@RequestParam String attid) {
        Boolean flag = attentionService.delGz(uid,attid);
        return flag;
    }



    @RequestMapping(value = "/Shouc/findSc/", method = RequestMethod.POST)
    public Boolean findDz(@RequestParam String scrid,
                          @RequestParam String zpid) {
        Boolean flag = attentionService.findSc(scrid, zpid);
        return flag;
    }

    @RequestMapping(value = "/Shouc/insertSc/", method = RequestMethod.POST)
    public Boolean insertSc(@RequestParam String scrid,
                            @RequestParam String zpid) {
        Boolean flag = attentionService.insertSc(scrid, zpid);
        return flag;
    }

    /**
     * 删除收藏对象
     * @param scrid
     * @param zpid
     * @return
     */
    @RequestMapping(value = "/Shouc/delSc", method = RequestMethod.POST)
    public Boolean delSc(@RequestParam String scrid,
                            @RequestParam String zpid) {
        Boolean flag = attentionService.delSc(scrid, zpid);
        return flag;
    }


    /**
     * 查询用户收藏列表
     * @param pageNum
     * @param pageSize
     * @param userid
     * @return
     */
    @RequestMapping(value = "/shouc/findAllSc", method = RequestMethod.POST)
    public PageInfo<Video> findAllSc(@RequestParam Integer pageNum,
                                      @RequestParam Integer pageSize
            , @RequestParam String userid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList=videoService.findScAll(pageNum, pageSize, userid);
        PageInfo<Video> videoPageInfo = new PageInfo<>(videoList, 10);
        return videoPageInfo;
    }

    /**
     * 查询用户个人视频
     * @param pageNum
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping(value = "/video/findMyVideo",method = RequestMethod.POST)
    public PageInfo<Video> findMyVideo(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize
            , @RequestParam String id) {
        /*查询个人视频*/
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList =userService.findMyVideoPage(pageNum, pageSize, id);
        PageInfo<Video> videoPageInfo = new PageInfo<>(videoList, 10);
        return videoPageInfo;
    }

    /**
     * 删除自己的视频；
     * @param vid
     * @return
     */
    @RequestMapping(value = "/video/delMyVideo",method = RequestMethod.POST)
    public Boolean delMyVideo(@RequestParam String vid){
        int i = videoService.deleteVideo(vid);
        Boolean flag=false;
        if (i>0)
        flag=true;
        return flag;
    }

    @RequestMapping(value = "/video/findFqVideo/", method = RequestMethod.POST)
    public PageInfo<Video> findVideoFq(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize
            , @RequestParam String fq) {
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videoList = videoService.findVideoByFq(pageNum, pageSize, fq);
        PageInfo<Video> videoPageInfo = new PageInfo<>(videoList, 10);
        return videoPageInfo;
    }

}
