package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class AppSyncBackPressed {
    public static long BackPressedTime;
    public static Toast backToast;
    public static void enable(Context context)
    {

        if (BackPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            ((Activity)context).finish();

            return;
        } else {
            backToast = Toast.makeText(context, "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        BackPressedTime = System.currentTimeMillis();
    }
}
