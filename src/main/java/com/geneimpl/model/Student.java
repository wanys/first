package com.geneimpl.model;

public class Student {
    private Integer stuid;

    private String stuname;

    private String stuage;

    private String stusex;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStuage() {
        return stuage;
    }

    public void setStuage(String stuage) {
        this.stuage = stuage == null ? null : stuage.trim();
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex == null ? null : stusex.trim();
    }
}