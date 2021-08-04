package com.teamup.app_sync;

import android.text.TextUtils;

public class AppSyncTextUtils {

    public static boolean check_empty(String text) {
        if (!TextUtils.isEmpty(text)) {

            return true;
        }
        return false;
    }

    public static boolean check_empty_and_null(String text) {
        if (!TextUtils.isEmpty(text) && !text.equalsIgnoreCase("null")) {

            return true;
        }
        return false;
    }
}
