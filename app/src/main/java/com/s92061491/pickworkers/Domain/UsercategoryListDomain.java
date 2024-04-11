package com.s92061491.pickworkers.Domain;

public class UsercategoryListDomain {
    String username;
    String jobtitle;
    String location;
    String desc;





    public UsercategoryListDomain(String username, String jobtitle, String location, String desc) {
        this.username = username;
        this.jobtitle = jobtitle;
        this.location = location;
        this.desc = desc;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
