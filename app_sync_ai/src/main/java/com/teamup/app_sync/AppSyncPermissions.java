package com.teamup.app_sync;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class AppSyncPermissions {
    public static void askPermissions(Context context, String[] permissions) {
        try {
            ActivityCompat.requestPermissions((Activity) context, permissions,
                    131);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void READ_WRITE_STORAAGE(Context context, int code) {
        try {
            String permissions[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

            ActivityCompat.requestPermissions((Activity) context, permissions,
                    code);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void CAMERA_PERMISSION(Context context, int code) {
        try {
            String permissions[] = {Manifest.permission.CAMERA};

            ActivityCompat.requestPermissions((Activity) context, permissions,
                    code);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void GPS_PERMISSIONS(Context context, int code) {
        try {
            String permissions[] = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_BACKGROUND_LOCATION};

            ActivityCompat.requestPermissions((Activity) context, permissions,
                    code);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static boolean check_read_write_permission(Context context) {
        try {
            int permissionCamera = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCamera == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static boolean check_camera_permission(Context context) {
        try {
            int permissionCamera = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);
            if (permissionCamera == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


//    private boolean hasManageExternalStoragePermission(String buildConfigPkgId, Context context) {
//            import static android.provider.Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            if (Environment.isExternalStorageManager()) {
//                return true;
//            } else {
//                if (Environment.isExternalStorageLegacy()) {
//                    return true;
//                }
//                try {
//                    Intent intent = new Intent();
//                    intent.setAction(ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
//                    intent.setData(Uri.parse("package:" + buildConfigPkgId));
//                    startActivityForResult(intent, 56); //result code is just an int
//                    return false;
//                } catch (Exception e) {
//                    Log.wtf("Hulk-err-285", e.getMessage());
//                    return false;
//                }
//            }
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            if (Environment.isExternalStorageLegacy()) {
//                return true;
//            } else {
//                try {
//                    Intent intent = new Intent();
//                    intent.setAction(ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
//                    intent.setData(Uri.parse("package:" + buildConfigPkgId));
//                    ((Activity)context).startActivityForResult(intent, 56); //result code is just an int
//                    return false;
//                } catch (Exception e) {
//                    return true; //if anything needs adjusting it would be this
//                }
//            }
//        }
//        return true; // assumed storage permissions granted
//    }

}
