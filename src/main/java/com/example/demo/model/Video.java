package com.example.demo.model;
/**
 * 视频类
 */

public class Video {
    private String vid;
    //视频标题
    private String vtitle;
    //视频路径
    private String vsrc;
    //视频封面路径
    private String picsrc;
    //视频简介
    private String descript;
    //上传时间
    private String uptime;
    //播放量
    private Integer looknum;
    //点赞数
    private Integer goodnum;
    //上传人id
    private String scrid;

    public String getScrname() {
        return scrname;
    }

    public void setScrname(String scrname) {
        this.scrname = scrname;
    }

    //上传人
    private String scrname;
    //视频状态
    private String state;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVtitle() {
        return vtitle;
    }

    public void setVtitle(String vtitle) {
        this.vtitle = vtitle;
    }

    public String getVsrc() {
        return vsrc;
    }

    public void setVsrc(String vsrc) {
        this.vsrc = vsrc;
    }

    public String getPicsrc() {
        return picsrc;
    }

    public void setPicsrc(String picsrc) {
        this.picsrc = picsrc;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public Integer getLooknum() {
        return looknum;
    }

    public void setLooknum(Integer looknum) {
        this.looknum = looknum;
    }

    public Integer getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(Integer goodnum) {
        this.goodnum = goodnum;
    }

    public String getScrid() {
        return scrid;
    }

    public void setScrid(String scrid) {
        this.scrid = scrid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
