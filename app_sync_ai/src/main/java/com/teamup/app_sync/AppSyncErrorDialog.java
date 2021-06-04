package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppSyncErrorDialog {

    static Dialog fetching;
    public static boolean dialogColsed = false;

    public static void showDialog(final Context context, String title, String text) {
        fetching = new Dialog(context);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        fetching.show();

        dialogColsed = false;

        fetching.setCancelable(false);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_error);

        TextView pleaseWaitTxt = fetching.findViewById(R.id.pleaseWaitTxt);
        TextView descTxt = fetching.findViewById(R.id.descTxt);
        Button doneBtn = fetching.findViewById(R.id.doneBtn);

        pleaseWaitTxt.setText("" + title);
        descTxt.setText("" + text);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doneBtnClicked();
                try {
                    ErrorSayings es = (ErrorSayings) context;
                    es.doneBtnClicked();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public interface ErrorSayings {
        public void doneBtnClicked();
    }

    private static boolean doneBtnClicked() {
        try {
            fetching.dismiss();
        } catch (Exception v) {

        }
        dialogColsed = true;
        return true;
    }


    public static void stopDialog(Context context) {
        try {
            fetching.dismiss();
        } catch (Exception v) {

        }
        dialogColsed = true;
    }

}
