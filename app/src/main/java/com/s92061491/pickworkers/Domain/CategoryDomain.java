package com.s92061491.pickworkers.Domain;

public class CategoryDomain {
    String title;
    String img;

    public CategoryDomain(String title, String img) {
        this.title = title;
        this.img = img;
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
}
