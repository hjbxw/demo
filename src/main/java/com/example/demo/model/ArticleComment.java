package com.example.demo.model;

import java.util.List;

public class ArticleComment {
    private String id;//主键id
    private String commentuserid;//创建该评论的用户id
    private User user;
    private String articleid;//评论的文章id
    private String content;//评论内容
    private String createtime;//评论的日期
    private List<ReplyComment> replyCommentList;
    public ArticleComment(){}
    public ArticleComment(String commentuserid,String articleid,String content){
        this.articleid=articleid;
        this.commentuserid=commentuserid;
        this.content=content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentuserid() {
        return commentuserid;
    }

    public void setCommentuserid(String commentuserid) {
        this.commentuserid = commentuserid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public List<ReplyComment> getReplyCommentList() {
        return replyCommentList;
    }

    public void setReplyCommentList(List<ReplyComment> replyCommentList) {
        this.replyCommentList = replyCommentList;
    }
}
