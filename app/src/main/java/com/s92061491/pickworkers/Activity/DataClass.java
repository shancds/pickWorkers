package com.s92061491.pickworkers.Activity;

public class DataClass {
    private String imgURL, caption;

    public DataClass(){

    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public DataClass(String imgURL, String caption) {
        this.imgURL = imgURL;
        this.caption = caption;
    }
}
