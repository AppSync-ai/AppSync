package com.teamup.app_sync;

import static android.util.Log.wtf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.teamup.app_sync.R;

public class AppSyncBackkgroundTint {

    public static void setBackgroundTint(int color, View view, Context context) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(color)));
            } else {
                Log.e("AppSync26", "Error setting background tint");
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setBackgroundTint(String hexcolor, View view, Context context) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(hexcolor)));
            } else {
                Log.e("AppSync38", "Error setting background tint");
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setTintToImage(int color, ImageView view, Context context) {
        try {
            view.setColorFilter(ContextCompat.getColor(context, color));
        } catch (Exception e) {
            Log.e("Error-36", e.getMessage());
            e.printStackTrace();
        }
    }

}
