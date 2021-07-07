package com.teamup.app_sync.Reqs;

public class SyncStatesReq {
    String state, link;

    public SyncStatesReq(String state, String link) {
        this.state = state;
        this.link = link;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
