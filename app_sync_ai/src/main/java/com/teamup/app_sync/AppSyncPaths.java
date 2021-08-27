package com.teamup.app_sync;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class AppSyncPaths {

    public static String DOWNLOADS = Environment.DIRECTORY_DOWNLOADS;
    public static String MOVIES = Environment.DIRECTORY_MOVIES;
    public static String ALBUMS = Environment.DIRECTORY_ALARMS;

    public static String getPath(String fileName, String folder) {
        String fname = "" + fileName;

        File dir = Environment.getExternalStoragePublicDirectory(folder);
        File file = new File(dir, fname);


        boolean isDirectoryCreated = dir.exists();
        if (!isDirectoryCreated) {
            dir.mkdir();
        }
        return file.getPath();
    }

    public static String specialPath(String folderName, String filename) {
        File root = new File(Environment.getExternalStorageDirectory(), folderName);
        File file = new File(root, filename);
        return file.getAbsolutePath();
    }

    public static String path_from_uri(Intent data, Context context) {
        String path = "";
        try {
            if (data != null) {

                String filePath = null;
                Uri _uri = data.getData();
                Log.d("", "URI = " + _uri);
                if (_uri != null && "content".equals(_uri.getScheme())) {
                    Cursor cursor = context.getContentResolver().query(_uri, new String[]{android.provider.MediaStore.Images.ImageColumns.DATA}, null, null, null);
                    cursor.moveToFirst();
                    filePath = cursor.getString(0);
                    cursor.close();
                } else {
                    filePath = _uri.getPath();
                }
                Log.d("app_sync_57", "Chosen path = " + filePath);

                path = filePath;

            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String get_scoped_path(Context context, String filenameWithExtension) {

        String path = "";
        if (AppSyncTextUtils.check_empty_and_null(filenameWithExtension)) {
            ContextWrapper cw = new ContextWrapper(context);
            File directory = cw.getDir(context.getResources().getString(R.string.app_name), Context.MODE_PRIVATE);
            try {
                directory.createNewFile();
            } catch (Exception c) {
                Log.wtf("Hulk-err-61", c.getMessage());
            }
            File file = new File(directory, filenameWithExtension);

            path = file.getAbsolutePath();
        } else {
            Log.wtf("Hulk-51", "Please enter path for get_scoped_path - filenameWithExtension");
        }
        return path;
    }

    public static String get_download_folder_path(Context context, String filenameWithExtension) {


        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(dir, filenameWithExtension);


        boolean isDirectoryCreated = dir.exists();
        if (!isDirectoryCreated) {
            dir.mkdir();
        }
        return file.getPath();


    }
}
