package com.teamup.app_sync;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;
import android.util.Log;

import java.io.File;

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

    public static String getDownloadFolderPath(Context context, String filenameWithExtension) {
        String path = "";
        ContextWrapper cw = new ContextWrapper(context);
        File directory = cw.getDir(context.getResources().getString(R.string.app_name), Context.MODE_PRIVATE);
        try {
            directory.createNewFile();
        } catch (Exception c) {
            Log.wtf("Hulk-err-61", c.getMessage());
        }
        File file = new File(directory, filenameWithExtension);

        path = file.getAbsolutePath();

        return path;
    }
}
