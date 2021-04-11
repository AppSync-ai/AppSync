package com.teamup.app_sync.ViewPagerFolder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.teamup.app_sync.R;

public class AppSyncBackkgroundTint {

    public static void setTintToButton(int color, View view, Context context) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(color)));
            } else {
                Log.e("AppSync19", "Error setting background tint");
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }


}
