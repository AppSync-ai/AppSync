package com.teamup.app_sync;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class AppSyncOpenUrl {
    public static void openUrl(Context context, String url) {
        String urlString = "" + url;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setPackage("com.android.chrome");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            //if Chrome browser not installed
            intent.setPackage(null);
            context.startActivity(intent);
        }
    }

    public static void openUrlViaIntent(Context context, String url) {
        try {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            context.startActivity(i);
        } catch (Exception e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
