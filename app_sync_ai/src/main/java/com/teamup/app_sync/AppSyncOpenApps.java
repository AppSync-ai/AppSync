package com.teamup.app_sync;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppSyncOpenApps {

    public static void openCalculatorApp(Context context) {

        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

            notFoundCalac(context);
        } catch (Exception c) {
            notFoundCalac(context);
        }


    }

    public static void notFoundCalac(Context context) {
        ArrayList<HashMap<String, Object>> items;
        PackageManager pm;
        List<PackageInfo> packs;

        // initialise From Oncreate if you want
        items = new ArrayList<HashMap<String, Object>>();
        pm = context.getPackageManager();
        packs = pm.getInstalledPackages(0);
        for (PackageInfo pi : packs) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("appName", pi.applicationInfo.loadLabel(pm));
            map.put("packageName", pi.packageName);
            items.add(map);
        }

        int d = 0;
        if (items.size() >= 1) {
            int j = 0;
            for (j = 0; j < items.size(); j++) {
                String AppName = (String) items.get(j).get("appName");
// Log.w("Name",""+AppName);
                if (AppName.matches("Calculator")) {
                    d = j;
                    break;
                }
            }
            String packageName = (String) items.get(d).get("packageName");

            Intent i = pm.getLaunchIntentForPackage(packageName);
            if (i != null) {
//                Toast.makeText(getApplicationContext(),"STARTING",Toast.LENGTH_SHORT).show();

                context.startActivity(i);
            } else {
                Toast.makeText(context, "SORRY CANT OPEN CALCULATOR :(", Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(context, "SORRY CANT START CALCULATOR :(", Toast.LENGTH_SHORT).show();


        }
    }


    public static void openCamera(Context context, int requestCode) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        ((Activity) context).startActivityForResult(intent, requestCode);
    }


    public static void openGpsSettings(Context context, int requestCode) {
        if (!isLocationEnabled(context)) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            ((Activity) context).startActivityForResult(intent, requestCode);
        }
    }

    public static Boolean isLocationEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
// This is new method provided in API 28
            LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            return lm.isLocationEnabled();
        } else {
// This is Deprecated in API 28
            int mode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE,
                    Settings.Secure.LOCATION_MODE_OFF);
            return (mode != Settings.Secure.LOCATION_MODE_OFF);

        }
    }


    public static void byPackageName(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        Intent launchIntent = pm.getLaunchIntentForPackage("" + packageName);
        if (launchIntent != null) {
            context.startActivity(launchIntent);
        } else {
            Toast.makeText(context, "No App found", Toast.LENGTH_SHORT).show();
        }
    }


//    *******************************************************************************************************

    public static void openDownloads(@NonNull Activity activity) {
        if (isSamsung()) {
            Intent intent = activity.getPackageManager()
                    .getLaunchIntentForPackage("com.sec.android.app.myfiles");
            intent.setAction("samsung.myfiles.intent.action.LAUNCH_MY_FILES");
            intent.putExtra("samsung.myfiles.intent.extra.START_PATH",
                    getDownloadsFile().getPath());
            activity.startActivity(intent);
        } else activity.startActivity(new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
    }

    public static boolean isSamsung() {
        String manufacturer = Build.MANUFACTURER;
        if (manufacturer != null) return manufacturer.toLowerCase().equals("samsung");
        return false;
    }

    public static File getDownloadsFile() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    }

//    *******************************************************************************************************


    public static void openFolder(String location, Context context) {
        // location = "/sdcard/my_folder";
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri mydir = Uri.parse("file://" + location);
            intent.setDataAndType(mydir, "application/*");    // or use */*
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "163 : " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
