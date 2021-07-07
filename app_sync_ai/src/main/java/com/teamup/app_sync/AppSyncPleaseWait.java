package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class AppSyncPleaseWait {

    static Dialog fetching;

    public static void showDialog(Context context, String text) {
        try {
            fetching = new Dialog(context);

            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            int width = metrics.widthPixels;
            int height = metrics.heightPixels;
            fetching.show();
            fetching.setCancelable(false);
            fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            fetching.setContentView(R.layout.fragment_plwase_wait);

            TextView pleaseWaitTxt = fetching.findViewById(R.id.pleaseWaitTxt);
            pleaseWaitTxt.setText("" + text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void stopDialog(Context context) {
        try {
            fetching.dismiss();
        } catch (Exception v) {

        }
    }

}
