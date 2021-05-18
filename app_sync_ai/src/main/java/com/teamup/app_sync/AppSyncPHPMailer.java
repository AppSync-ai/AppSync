package com.teamup.app_sync;

import android.content.Context;
import android.util.Log;

public class AppSyncPHPMailer {

    public static boolean sendMail(Context context, String toMail, String subject, String message) {
        String resp = AppSyncDirectResponse.getResponse(cctoast.mail + "?to=" + toMail + "&subject=" + subject + "&message=" + message);

        Log.wtf("Hulk-77", cctoast.mail + "?to=" + toMail + "&subject=" + subject + "&message=" + message);

        if (resp.contains("Email Sent")) {
            return true;
        } else {
            return false;
        }
    }
}
