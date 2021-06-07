package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import static com.teamup.app_sync.AppSyncTorch.CAMERA_REQUEST;

public class AppSyncCamera {
    public static void takePhoto(Context context, int code)
    {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        ((Activity)context).startActivityForResult(cameraIntent, code);
    }
}
