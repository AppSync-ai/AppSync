package com.teamup.rohitasawa_library;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class RohitPermissions {
    public static void askPermissions(Context context, String[] permissions)
    {
        try {
            ActivityCompat.requestPermissions((Activity) context, permissions,
                    131);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void READ_WRITE_STORAAGE(Context context, int code)
    {
        try {
            String permissions[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

            ActivityCompat.requestPermissions((Activity) context, permissions,
                    code);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void CAMERA_PERMISSION(Context context, int code)
    {
        try {
            String permissions[] = {Manifest.permission.CAMERA};

            ActivityCompat.requestPermissions((Activity) context, permissions,
                    code);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void GPS_PERMISSIONS(Context context, int code)
    {
        try {
            String permissions[] = {Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_BACKGROUND_LOCATION};

            ActivityCompat.requestPermissions((Activity) context, permissions,
                    code);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static boolean check_read_write_permission(Context context)
    {
        try {
            int permissionCamera = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCamera == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static boolean check_camera_permission(Context context)
    {
        try {
            int permissionCamera = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);
            if (permissionCamera == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
