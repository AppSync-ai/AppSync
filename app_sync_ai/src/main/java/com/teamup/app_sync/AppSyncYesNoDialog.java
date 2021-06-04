package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class AppSyncYesNoDialog {
    static Dialog fetching;

    public static void showDialog(final Context context, String title) {
        fetching = new Dialog(context);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        fetching.show();

        fetching.setCancelable(false);
        fetching.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_yes_no);


        ImageButton yesBtn = fetching.findViewById(R.id.yesBtn);
        ImageButton noBtn = fetching.findViewById(R.id.noBtn);
        TextView txt = fetching.findViewById(R.id.txt);

        txt.setText("" + title);


        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialogSayings green = (dialogSayings) context;
                    green.redSignal();
                    stopDialog(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.wtf("Hulk-47", "Please implement Yes No Dialog ");
                }
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialogSayings green = (dialogSayings) context;
                    green.greenSignal();
                    stopDialog(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.wtf("Hulk-47", "Please implement Yes No Dialog ");
                }
            }
        });


    }

    public interface dialogSayings {
        public void greenSignal();

        public void redSignal();
    }

    public static void stopDialog(Context context) {
        try {
            fetching.dismiss();
        } catch (Exception v) {

        }
    }

}
