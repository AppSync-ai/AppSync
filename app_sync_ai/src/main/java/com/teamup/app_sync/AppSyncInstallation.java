package com.teamup.app_sync;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;

public class AppSyncInstallation {
    static Context contextThis;
    static AppSyncStorage appSyncStorage;

    public static void set_instaltion(Context context) {
        contextThis = context;
        appSyncStorage = new AppSyncStorage(context);
        if (TextUtils.isEmpty(appSyncStorage.getString("app_date"))) {
            appSyncStorage.putString("app_date", AppSyncCurrentDate.getDate());
        } else {
//            AppSyncToast.showToast(context, "" + appSyncStorage.getString("app_date"));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int get_days_being_installed() {
        int days = 0;
        try {
            days = AppSyncDaysTheory.differenceBetweenDays(appSyncStorage.getString("app_date"), AppSyncCurrentDate.getDate(), "dd/MM/yyyy");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return days;
    }
}
