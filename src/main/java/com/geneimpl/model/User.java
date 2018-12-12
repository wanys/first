package com.geneimpl.model;

public class User {
    private Integer id;

    private String username;

    private String userpsw;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpsw() {
        return userpsw;
    }

    public void setUserpsw(String userpsw) {
        this.userpsw = userpsw == null ? null : userpsw.trim();
    }

    @Override
    public String toString() {
        return "用户：id="+id+"姓名："+username+"密码"+userpsw;
    }
}