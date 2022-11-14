package com.teamup.app_sync;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.net.URLEncoder;

public class AppSyncWhatsappToNo {
    public static void sendToNo(Context context, String MobileNo, String message) {

        MobileNo = MobileNo.replace("+", "");

        try {
            String url = "https://api.whatsapp.com/send?phone=" +  MobileNo + "&text=" + URLEncoder.encode("" + message, "UTF-8");
            AppSyncOpenUrl.openUrlViaIntent(context, url);

        } catch (Exception e) {

            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }

    }
}
