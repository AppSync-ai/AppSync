package com.teamup.app_sync.ViewPagerFolder;


import androidx.annotation.Keep;




/**
 * Created by Sai on 23/07/2018.
 */
@Keep
public class pagerReq {

    private String imgUrl, link;


    public pagerReq() {
    }

    public pagerReq(String imgUrl, String link) {
        this.imgUrl = imgUrl;
        this.link = link;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}