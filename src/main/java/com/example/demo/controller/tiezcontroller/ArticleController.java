package com.example.demo.controller.tiezcontroller;

import com.example.demo.Cache.TagCache;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.*;
import com.example.demo.service.tieziservice.ArticleService;
import com.example.demo.utils.MyStringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

//问题详情
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    private HttpSession session;

    @ResponseBody
    @RequestMapping(value = "/article/getAll",method = RequestMethod.POST)
    public PageInfo<Article> findArticle(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articleList= articleService.findArList(pageNum, pageSize);
        PageInfo<Article> articlePageInfo = new PageInfo<>(articleList);
        return articlePageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/article/create",method = RequestMethod.POST)
    public Article uptiez(Article article){
        if (!StringUtils.isEmpty(article)){
            article.setId(MyStringUtils.getUUID());
            article.setCreatetime(MyStringUtils.getTime());
            article.setLike_count(0);
            article.setViewnum(0);
            articleService.createArticle(article);
            return article;
        }else
            return null;
    }

    @GetMapping("/fbtiezi")
    public String publish() {
        return "/tiezi/publish.html";
    }

    @GetMapping("/article/tzinfo")
    public String toTzInfo(String id, Model model){
        articleService.incatrlook(id);
        Article article = articleService.findArById(id);
        model.addAttribute(article);
        return "/tiezi/articleInfo.html";
    }

    @ResponseBody
    @RequestMapping(value = " /dianz/artincdz/",method = RequestMethod.POST)
    public Article incDz(Article article){
        if (!StringUtils.isEmpty(article)){
            articleService.editArt(article);
            return article;
        }else
            return null;
    }

    @ResponseBody
    @RequestMapping(value = "/luntan/findtiezi",method = RequestMethod.POST)
    public PageInfo<Article> findMy(@RequestParam String id, @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articleList = articleService.findArByUserId(id, pageNum, pageSize);
        PageInfo<Article> articlePageInfo=new PageInfo<>(articleList,10);
        return articlePageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/luntan/ssTz",method = RequestMethod.POST)
    public PageInfo<Article> findByTitle(@RequestParam String title,
                                         @RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articleList = articleService.findArByTitle(title, pageNum, pageSize);
        PageInfo<Article> articlePageInfo=new PageInfo<>(articleList,10);
        return articlePageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/luntan/delTiezi",method = RequestMethod.POST)
    public String delTz(@RequestParam String id){
       articleService.delTiezi(id);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/article/getTags",method = RequestMethod.POST)
    public List<TagModel> fb() {
        TagCache tagCache=new TagCache();
        List<TagModel> tags = tagCache.gettags();
        return tags;
    }

    @ResponseBody
    @RequestMapping(value = "/article/uppic",method = RequestMethod.POST)
    public Map uppic(@RequestParam(value = "editormd-image-file", required = false) MultipartFile pic,
                     HttpServletRequest request) {
        Map resmap = new HashMap();
        File imageFolder= new File(request.getServletContext().getRealPath("img/upload"));
        String path =null;
        String picsrc = pic.getOriginalFilename();
        path = "E:/fileUpload/luntanpic/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + picsrc;
        String norealurl = "/static/luntanpic/"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + picsrc;
        //创建文件路径
        File dest = new File(path);
        //判断文件是否已经存在
        if (dest.exists()) {
            resmap.put("success", 0);
            return resmap;
        }
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //上传文件
            pic.transferTo(dest);
            resmap.put("success", 1);
            resmap.put("message", "上传成功");
            resmap.put("url", norealurl);
        } catch (IOException e) {
            resmap.put("success", 0);
            return resmap;
        }
        return resmap;
    }

    @GetMapping("/editarticle/{id}")
    public String edit(@PathVariable(name = "id")String id,
                       Model model){
        Article article=articleService.findArById(id);
        model.addAttribute("title", article.getTitle());
        model.addAttribute("description", article.getDescription());
        model.addAttribute("tag", article.getTag());
        //用来标识问题是修改而不是重新创建
        model.addAttribute("id",article.getId());
        return "/tiezi/editarticle.html";
    }

    @ResponseBody
    @RequestMapping(value = "/article/editArticle",method = RequestMethod.POST)
    public Article edit(Article article){
        if (!StringUtils.isEmpty(article)){
           articleService.editArt(article);
            return article;
        }else
            return null;
    }

    @ResponseBody
    @RequestMapping(value = "/common/deleteTz/{id}")
    public Code delTz2(@PathVariable String id){
       articleService.delTiezi(id);
       Code code = new Code();
       code.setCode("1");
       return code;
    }
}
