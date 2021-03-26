package com.teamup.rohitasawa_library;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

public class RohitChangeNavigationColor {
    public static void change(Context context)
    {
        try {
            try {
                Window window = ((Activity)context).getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.setStatusBarColor(((Activity)context).getResources().getColor(R.color.colorPrimaryDark));
                    window.setNavigationBarColor(((Activity)context).getResources().getColor(R.color.colorPrimaryDark));
                }
            } catch (Exception c) {
            }

        }
        catch (Exception v)
        {
            v.printStackTrace();
        }

    }
}
