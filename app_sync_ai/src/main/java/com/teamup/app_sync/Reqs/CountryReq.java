package com.teamup.app_sync.Reqs;

public class CountryReq {
    String title, description, img_url;

    public CountryReq(String title, String description, String img_url) {
        this.title = title;
        this.description = description;
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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}