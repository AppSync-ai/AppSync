package com.teamup.app_sync.Reqs;

public class SyncNewsReq {
    String title, description, date, img_url;

    public SyncNewsReq(String title, String description, String date, String img_url) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}