package com.teamup.app_sync;

import android.content.Context;
import android.widget.Toast;


public class AppSyncToast {

    public static void showToast(Context context, String title) {
        try {

            new cctoast(context)
                    .setMessage(title)
                    .setDuration(Toast.LENGTH_SHORT)
                    .setBackgroundColor(context.getResources().getColor(R.color.colorAccent))
                    .show();
        } catch (Exception e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }
}
