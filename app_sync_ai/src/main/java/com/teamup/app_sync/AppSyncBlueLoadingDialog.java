package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;

public class AppSyncBlueLoadingDialog {

    static Dialog fetching;
    public static boolean dialogColsed = false;

    public static void showDialog(Context context){
        fetching= new Dialog(context);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        fetching.show();

        dialogColsed = false;

        fetching.setCancelable(false);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_blue_loading);



    }



    public static void stopDialog(Context context){
        try {
            if (fetching != null) {
                if (fetching.isShowing()) {
                    fetching.dismiss();
                    dialogColsed = true;
                }
            }
        }
        catch (Exception v)
        {
            Log.e("Hulk-a-46", "stopDialog: : "+v);
        }

    }

}
