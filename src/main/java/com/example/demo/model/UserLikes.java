package com.example.demo.model;

import java.util.List;

public class UserLikes {
    private String uid;
    private String uname;
    private String attid;
    private String attname;
    private List<User> users;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAttid() {
        return attid;
    }

    public void setAttid(String attid) {
        this.attid = attid;
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
