package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class AppSyncNewPleaseWait {
    public static View view2;
    public static AlertDialog customDialog;
    static TextView desc_txt;
    static ImageView close_img;

    public static void showDialog(final Context context, String text, int backGroundColor, int stopAfterLongInt, int show_close_btn_after_seconds) {
        try {

            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.myFullscreenAlertDialogStyle);
            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
            view2 = layoutInflaterAndroid.inflate(R.layout.new_pleasewait, null);
            builder.setView(view2);
            builder.setCancelable(false);
            customDialog = builder.create();
            try {
                if (backGroundColor == 0) {
                    customDialog.getWindow().setBackgroundDrawableResource(R.color.new_white_transparent);
                } else {
                    customDialog.getWindow().setBackgroundDrawableResource(backGroundColor);
                }
            } catch (Exception c) {
                Toast.makeText(context, "Wrong background color", Toast.LENGTH_SHORT).show();
            }


            TextView pleaseWaitTxt = view2.findViewById(R.id.pleaseWaitTxt);
            close_img = view2.findViewById(R.id.close_img);
            close_img.setVisibility(View.GONE);
            desc_txt = view2.findViewById(R.id.desc_txt);
            pleaseWaitTxt.setText("" + text);

            close_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stopDialog(context);
                }
            });

            customDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (stopAfterLongInt != 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    stopDialog(context);
                }
            }, stopAfterLongInt);
        }
        if (show_close_btn_after_seconds != 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    close_img.setVisibility(View.VISIBLE);
                }
            }, show_close_btn_after_seconds);
        }

    }

    public static void setDescription(String description) {
        desc_txt.setText("" + description);
    }

    public static void stopDialog(Context context) {
        try {
            customDialog.dismiss();

        } catch (Exception v) {

        }

        try {
            NewPleaseWaitDialog np = (NewPleaseWaitDialog) context;
            np.DialogClosed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface NewPleaseWaitDialog {
        public void DialogClosed();
    }

}
