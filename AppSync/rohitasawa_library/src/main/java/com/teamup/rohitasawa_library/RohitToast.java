package com.teamup.rohitasawa_library;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;


public class RohitToast {

    public static void showToast(Context context, String title) {
        try {

            new cctoast(context)
                    .setMessage(title)
                    .setDuration(Toast.LENGTH_SHORT)
                    .setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark))
                    .show();
        } catch (Exception e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }
}
