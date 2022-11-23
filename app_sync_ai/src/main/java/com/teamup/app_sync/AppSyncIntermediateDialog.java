package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class AppSyncIntermediateDialog {

    static Dialog fetching;

    public static void showDialog(Context context, String text, boolean calcelable) {
        fetching = new Dialog(context, R.style.myFullscreenAlertDialogStyle);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        fetching.show();

        fetching.setCancelable(calcelable);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.intermediate_progress);

        TextView pleaseWaitTxt = fetching.findViewById(R.id.pleaseWaitTxt);
        pleaseWaitTxt.setText("" + text);

    }


    public static void stopDialog(Context context) {
        try {
            if (fetching != null) {
                fetching.dismiss();
            }
        } catch (Exception v) {

        }
    }

}
