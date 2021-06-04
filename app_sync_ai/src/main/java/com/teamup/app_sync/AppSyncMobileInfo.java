package com.teamup.app_sync;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

public class AppSyncMobileInfo {
    public static int getSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getVersionRelease() {
        return Build.VERSION.RELEASE;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getAndroidID(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } catch (Exception v) {

        }

        return "Error";
    }

    public static String getThisAppName(Context context) {

        return context.getString(R.string.app_name);
    }
}
