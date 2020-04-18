package com.example.demo.controller.videocontroller;

import com.example.demo.model.ArticleComment;
import com.example.demo.model.ReplyComment;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.commentservice.ArticleCommentService;
import com.example.demo.service.commentservice.ReplyCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.ContentTypeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CommentRestController
{
    @Autowired
    private ArticleCommentService articleCommentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReplyCommentService replyCommentService;

    @RequestMapping(value = "/comments/addComments")
    public @ResponseBody
    Map<String, String> addComments(
            @RequestParam(value = "articleid", required = true) String articleid,
            @RequestParam(value = "content", required = true) String content,
            @RequestParam(value = "userid", required = true) String userid,
            HttpServletRequest request,
            HttpServletResponse response) {
        Map<String, String> result = new HashMap<>();
        if (!StringUtils.isEmpty(articleid)) {
            ArticleComment articleComment = new ArticleComment();

            articleComment.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            articleComment.setId(UUID.randomUUID().toString().replace("-", ""));
            articleComment.setArticleid(articleid);
            articleComment.setCommentuserid(userid);
            articleComment.setContent(content);
            result.put("status", articleCommentService.addArticleComment(articleComment) + "");
            result.put("success", "1");
        } else {
            result.put("success", "0");
        }
        return result;
    }

    @RequestMapping(value = "/comments/getComments")
    public @ResponseBody
    List<ArticleComment> getCommentsByArticleId(@RequestParam(value = "articleid", required = true) String articleid) {
        if(!StringUtils.isEmpty(articleid))
            return articleCommentService.getArticleCommentsByArticleId(articleid);
        else return null;
    }

    @RequestMapping(value = "/comments/addReplyComment")
    public @ResponseBody
    Map<String, String> addReplyComment(
            @RequestParam(value = "articleid", required = true) String articleid,
            @RequestParam(value = "commentid", required = true) String commentid,
            @RequestParam(value = "replieduserid", required = true) String replieduserid,
            @RequestParam(value = "content", required = true) String content,
            HttpServletRequest request
    ) {
        String replyuserid=null;
        Map<String, String> result = new HashMap<>();
        if (StringUtils.isEmpty(articleid)) {
            ReplyComment replyComment=new ReplyComment(articleid,commentid,replyuserid,replieduserid,content);
            int status=replyCommentService.addReplyCommentMapper(replyComment);
            result.put("status",status+"");
            result.put("success","1");
        } else {
            result.put("success", "0");
        }
        return result;
    }

    @RequestMapping(value = "/comments/getUser")
    public @ResponseBody
    User getYser(@RequestParam(value = "articleid", required = true) String userid) {
        return userService.findUserById(userid);
    }

}
