package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;

import androidx.loader.content.CursorLoader;

public class AppSyncMusicPicker {
    public static void open(Context context, int code) {
        Intent audio_picker_intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        ((Activity) context).startActivityForResult(audio_picker_intent, code);
    }

    public static String getFilePath(Context context, Intent data) {
        String filePath = "";
        if (data != null) {
            Uri audioFileUri = data.getData();
            filePath = getRealPathFromURI(audioFileUri, context);

            return filePath;
        } else {
            AppSyncToast.showToast(context, "Please select song properly");
        }
        return null;
    }

    private static String getRealPathFromURI(Uri contentUri, Context context) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(context, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

}
