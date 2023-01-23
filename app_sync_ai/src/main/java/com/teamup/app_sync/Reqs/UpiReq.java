package com.teamup.app_sync.Reqs;

import android.graphics.drawable.Drawable;

public class UpiReq {
    String title, package_id;
    Drawable img_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    public Drawable getImg_url() {
        return img_url;
    }

    public void setImg_url(Drawable img_url) {
        this.img_url = img_url;
    }
}