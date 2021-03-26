package com.teamup.app_sync;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class AppSyncProgressDialog {

    public static AlertDialog customDialog;
    public static View view2;
    private static int progress = 0;
    private static ProgressBar progressBar;
    public static TextView percentTxt;
    public static Context ctx;

    public static void showDialog(Context context, String title, int BackgroundColor) {
        ctx = context;
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.myFullscreenAlertDialogStyle);
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
        view2 = layoutInflaterAndroid.inflate(R.layout.incremental_progress, null);
        builder.setView(view2);
        builder.setCancelable(false);
        customDialog = builder.create();
        try {
            customDialog.getWindow().setBackgroundDrawableResource(BackgroundColor);
        } catch (Exception c) {
            Toast.makeText(context, "Wrong background color", Toast.LENGTH_SHORT).show();
        }

        customDialog.show();
        TextView titleTxt = view2.findViewById(R.id.titleTxt);
        percentTxt = view2.findViewById(R.id.percentTxt);
        titleTxt.setText("" + title);

        progressBar = view2.findViewById(R.id.progressBar);
        setProgress(0);

    }

    public static void StopDialog(Context context) {
        try {
            customDialog.dismiss();
        } catch (Exception v) {

        }
    }

    public static void setProgress(int progress) {
        AppSyncProgressDialog.progress = progress;
        progressBar.setProgress(progress);
        percentTxt.setText("" + progress + "%");

        try {
            if (progress == 100) {
                status st = (status) ctx;
                st.completed();
            }
        } catch (Exception v) {

        }

    }

    public static int getProgress() {
        return progress;
    }

    public interface status {
        public void completed();
    }
}
