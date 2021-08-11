package com.teamup.app_sync.Reqs;

public class MessagesReq {
    String message, time_and_date;
    int bot_msg;

    public MessagesReq(String message, String time_and_date, int bot_msg) {
        this.message = message;
        this.time_and_date = time_and_date;
        this.bot_msg = bot_msg;
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

    public int getBot_msg() {
        return bot_msg;
    }

    public void setBot_msg(int bot_msg) {
        this.bot_msg = bot_msg;
    }
}