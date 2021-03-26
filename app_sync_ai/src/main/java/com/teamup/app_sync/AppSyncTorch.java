package com.teamup.app_sync;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class AppSyncTorch {

    public static boolean hasCameraFlash = false;
    public static final int CAMERA_REQUEST = 123;

    public static void start(Context context)
    {

        ActivityCompat.requestPermissions(
                (Activity) context,
                new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);

        hasCameraFlash = context.getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (hasCameraFlash) {

            CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);

            try {
                String cameraId = cameraManager.getCameraIdList()[0];
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    cameraManager.setTorchMode(cameraId, true);
                }
            } catch (CameraAccessException e) {
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void stop(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
        } catch (CameraAccessException e) {
        }
    }
}
