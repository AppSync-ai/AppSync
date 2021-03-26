package com.teamup.rohitasawa_library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;

public class RohitVideoPicker {

    public static int VIDEO_PICKER_CODE = 455;

    public static void Pick(Context context) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        ((Activity) context).startActivityForResult(intent, VIDEO_PICKER_CODE);
    }

    public static String getPath(Context context, Intent data) {
        if (data != null) {
            Uri selectedImageUri = data.getData();

            String[] filePathColumn = {MediaStore.Video.Media.DATA};

            Cursor cursor = context.getContentResolver().query(selectedImageUri, filePathColumn, null, null, null);
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
