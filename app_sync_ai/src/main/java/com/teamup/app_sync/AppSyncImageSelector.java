package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;

public class AppSyncImageSelector {

    public static void openGalleryAndSelect(Context context) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        ((Activity) context).startActivityForResult(galleryIntent, 0);
    }

    public static String getPath(Context context, Intent data) {
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

    public static File getFile(Context context, Intent data) {
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
            File myFile = new File(mediaPath);


            return myFile;
        } else {
            Toast.makeText(context, "data is null", Toast.LENGTH_SHORT).show();
        }
        return null;
    }


}
