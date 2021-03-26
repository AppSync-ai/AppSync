package com.teamup.rohitasawa_library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class RohitCustomDialog {

    public static AlertDialog customDialog;
    public static View view2;

    public static void showDialog(Context context, int layout, int backgroundColor, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.myFullscreenAlertDialogStyle);
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
        view2 = layoutInflaterAndroid.inflate(layout, null);
        builder.setView(view2);
        builder.setCancelable(cancelable);
        customDialog = builder.create();
        try {
            customDialog.getWindow().setBackgroundDrawableResource(backgroundColor);
        } catch (Exception c) {
            Toast.makeText(context, "Wrong background color", Toast.LENGTH_SHORT).show();
        }

        customDialog.show();


    }

    public static void stopPleaseWaitDialog(Context context) {
        try {
            customDialog.dismiss();
        } catch (Exception v) {

        }
    }

}
