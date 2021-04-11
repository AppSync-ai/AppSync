package com.teamup.app_sync;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AppSyncUpdate {
    static Dialog fetching;

    public static void checkForUpdate(Context context, String update, String buildConfigVersionName) {

        if (buildConfigVersionName.equalsIgnoreCase(update)) {

        } else {
            showDialog(context);
        }
    }

    public static void showDialog(final Context context) {
        fetching = new Dialog(context);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        fetching.show();


        fetching.setCancelable(false);
        fetching.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_update);

        TextView update = fetching.findViewById(R.id.update);
        TextView cancel = fetching.findViewById(R.id.cancel);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String appPackageName = context.getPackageName();
                AppSyncOpenUrl.openUrl(context, "market://details?id=" + appPackageName);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((Activity) context).finish();
                fetching.dismiss();

            }
        });

    }

    public static void stopDialog(Context context) {
        fetching.dismiss();
    }

}
