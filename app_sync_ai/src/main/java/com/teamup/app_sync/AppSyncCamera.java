package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

import static com.teamup.app_sync.AppSyncTorch.CAMERA_REQUEST;

public class AppSyncCamera {
    public static void takePhoto(Context context, int code) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        ((Activity) context).startActivityForResult(cameraIntent, code);
    }

    public static String get_path(Context context, Intent data) {
        if (data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = context.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String mediaPath = cursor.getString(columnIndex);
            // Set the Image in ImageView for Previewing the Media
            cursor.close();

            return mediaPath;
        } else {
            Toast.makeText(context, "data is null", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
}
