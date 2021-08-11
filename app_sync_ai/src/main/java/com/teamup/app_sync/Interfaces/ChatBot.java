package com.teamup.app_sync.Interfaces;

import com.teamup.app_sync.Reqs.UserMessagesReq;

import java.util.ArrayList;

public interface ChatBot {
        public void user_responded(String response);

        public void chat_end(ArrayList<UserMessagesReq> list);

    }