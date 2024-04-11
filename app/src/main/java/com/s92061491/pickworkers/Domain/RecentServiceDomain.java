package com.s92061491.pickworkers.Domain;

public class RecentServiceDomain {
    private  String title;
    private  String img;
    private Double star;
    private Double time;

    public RecentServiceDomain(String title, String img, Double star, Double time) {
        this.title = title;
        this.img = img;
        this.star = star;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }
}
