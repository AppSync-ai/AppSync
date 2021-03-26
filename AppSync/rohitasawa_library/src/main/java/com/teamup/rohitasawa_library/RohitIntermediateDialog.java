package com.teamup.rohitasawa_library;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class RohitIntermediateDialog {

    static Dialog fetching;

    public static void showDialog(Context context, String text){
        fetching= new Dialog(context, R.style.myFullscreenAlertDialogStyle);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        fetching.show();

        fetching.setCancelable(false);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.intermediate_progress);

        TextView pleaseWaitTxt = fetching.findViewById(R.id.pleaseWaitTxt);
        pleaseWaitTxt.setText(""+text);

    }


    public static void stopDialog(Context context){
        try {
            fetching.dismiss();
        }
        catch (Exception v)
        {

        }
    }

}
