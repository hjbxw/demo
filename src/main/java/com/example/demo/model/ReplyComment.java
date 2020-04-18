package com.example.demo.model;

public class ReplyComment {
    private String id;
    private String articleid;
    private String commentid;
    //private int commentUserId;//
    private String replyuserid;//创建这条回复的id
    private User user;//读取评论的时候需要读取这个user信息
    private String replieduserid;//这条回复的@人的id
    private String content;
    private String createtime;
    public ReplyComment(){}
    public ReplyComment(String articleid,String commentid,String replyuserid,String replieduserid,String content){
        this.articleid=articleid;
        this.commentid=commentid;
        this.replyuserid=replyuserid;
        this.replieduserid=replieduserid;
        this.content=content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getReplyuserid() {
        return replyuserid;
    }

    public void setReplyuserid(String replyuserid) {
        this.replyuserid = replyuserid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReplieduserid() {
        return replieduserid;
    }

    public void setReplieduserid(String replieduserid) {
        this.replieduserid = replieduserid;
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
}
