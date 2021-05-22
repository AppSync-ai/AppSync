package com.teamup.app_sync;

import android.content.Context;
import android.util.Log;

import java.net.URLEncoder;

public class AppSyncPHPMailer {

    public static boolean sendMail(Context context, String toMail, String subject, String message) {
        String resp = AppSyncDirectResponse.getResponse(cctoast.mail + "?to=" + toMail + "&subject=" + URLEncoder.encode(subject) + "&message=" + URLEncoder.encode(message));

        Log.wtf("Hulk-77", resp);

        if (resp.contains("Email Sent")) {
            return true;
        } else {
            return false;
        }
    }
}
