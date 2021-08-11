package com.teamup.app_sync.Reqs;

public class UserMessagesReq {
    String message, time_and_date;

    public UserMessagesReq(String message, String time_and_date) {
        this.message = message;
        this.time_and_date = time_and_date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime_and_date() {
        return time_and_date;
    }

    public void setTime_and_date(String time_and_date) {
        this.time_and_date = time_and_date;
    }
}