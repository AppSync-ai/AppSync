package com.teamup.rohitasawa_library;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class RohitDialog {

    public static void showDialog(Context context, String title, String message, String buttonName) {
        try {


            new AlertDialog.Builder(context)
                    .setMessage(""+message)
                    .setTitle(""+title)
                    .setCancelable(false)
                    .setPositiveButton(buttonName, null)
                    .show();

        } catch (Exception g) {

            Toast.makeText(context, ""+g, Toast.LENGTH_SHORT).show();
        }
    }
}
