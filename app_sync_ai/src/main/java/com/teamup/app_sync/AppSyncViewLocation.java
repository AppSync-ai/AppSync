package com.teamup.app_sync;

import android.view.View;

public class AppSyncViewLocation {

    public static int locationX(View view) {
        int[] point = new int[2];
        view.getLocationOnScreen(point);
        return point[0];
    }

    public static int locationY(View view) {
        int[] point = new int[2];
        view.getLocationOnScreen(point);
        return point[1];
    }
}
