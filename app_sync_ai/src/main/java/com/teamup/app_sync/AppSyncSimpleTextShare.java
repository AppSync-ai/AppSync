package com.teamup.app_sync;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.teamup.app_sync.BuildConfig;

public class AppSyncSimpleTextShare {
    public static void share(Context context, String shareMesage)
    {
        try {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
            shareIntent.setType("text/plain");

            String shareMessage = "\n"+shareMesage;

            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

            context.startActivity(Intent.createChooser(shareIntent, "choose app to share.."));
        } catch (Exception e) {
            //e.toString();
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }
    }
}

