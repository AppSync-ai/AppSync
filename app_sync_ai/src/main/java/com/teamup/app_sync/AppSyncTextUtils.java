package com.teamup.app_sync;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

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

    public static boolean check_empty_and_null(String text, Context context, String message) {
        if (!TextUtils.isEmpty(text) && !text.equalsIgnoreCase("null")) {
            return true;
        }
        AppSyncToast.showToast(context, message);
        return false;
    }

    public static boolean check_empty_and_null(EditText editText, Context context, String message) {
        if (!TextUtils.isEmpty(editText.getText().toString()) && !editText.getText().toString().equalsIgnoreCase("null")) {
            return true;
        }
        AppSyncToast.showToast(context, message);
        return false;
    }
}
