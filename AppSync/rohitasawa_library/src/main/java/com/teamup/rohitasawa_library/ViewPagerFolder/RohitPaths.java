package com.teamup.rohitasawa_library.ViewPagerFolder;

import android.content.Context;
import android.os.Environment;

import com.teamup.rohitasawa_library.RohitMobileInfo;

import java.io.File;

public class RohitPaths {

    public static String DOWNLOADS =  Environment.DIRECTORY_DOWNLOADS;
    public static String MOVIES =  Environment.DIRECTORY_MOVIES;
    public static String ALBUMS =  Environment.DIRECTORY_ALARMS;

    public static String getPath(String fileName, String folder){
        String fname = "" + fileName;

        File dir = Environment.getExternalStoragePublicDirectory(folder);
        File file = new File(dir, fname);


        boolean isDirectoryCreated = dir.exists();
        if (!isDirectoryCreated) {
            dir.mkdir();
        }
        return file.getPath();
    }

    public static String specialPath(String folderName, String filename){
        File root = new File(Environment.getExternalStorageDirectory(), folderName);
        File file = new File(root, filename);
        return file.getAbsolutePath();
    }
}
