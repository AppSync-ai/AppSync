package com.teamup.app_sync;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AppSyncShareApp {

    public static void shareApp(Context context, String shareMesage, String buildConfigApplicationId) {
        try {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            shareIntent.setType("text/plain");

            String shareMessage = "\n" + shareMesage + "\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + buildConfigApplicationId + "\n";

            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

            context.startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            //e.toString();
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }
}
