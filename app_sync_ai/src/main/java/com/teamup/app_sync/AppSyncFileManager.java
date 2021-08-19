package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AppSyncFileManager {
    public static void openFileChooser(Context context, int code) {

//        Import this library if needed bcoz reference of fileutil is from this library
//        implementation 'org.apache.directory.studio:org.apache.commons.io:2.4'

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);

        try {
            ((Activity) context).startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    code);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
        }
    }

    public static String getSelectedFilePath(Context context, Intent data) throws IOException {
        return importFile(data.getData(), context);
    }

    private static String importFile(Uri uri, Context context) throws IOException {
        String fileName = getFileName(uri, context);

        // The temp file could be whatever you want
        File tempFile = new File(AppSyncPaths.get_download_folder_path(context, fileName.replace(" ", "_").toLowerCase()).replace("-", "_"));
        File fileCopy = copyToTempFile(uri, tempFile, context);

        // Done!
//        AppSyncToast.showToast(getApplicationContext(), fileName);

        return fileCopy.getAbsolutePath();
    }


    private static String getFileName(Uri uri, Context context) throws IllegalArgumentException {
        // Obtain a cursor with information regarding this uri
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);

        if (cursor.getCount() <= 0) {
            cursor.close();
            throw new IllegalArgumentException("Can't obtain file name, cursor is empty");
        }

        cursor.moveToFirst();

        String fileName = cursor.getString(cursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME));

        cursor.close();

        return fileName;
    }

    /**
     * Copies a uri reference to a temporary file
     *
     * @param uri      the uri used as the input stream
     * @param tempFile the file used as an output stream
     * @return the input tempFile for convenience
     * @throws IOException if an error occurs
     */
    private static File copyToTempFile(Uri uri, File tempFile, Context context) throws IOException {
        // Obtain an input stream from the uri
        InputStream inputStream = context.getContentResolver().openInputStream(uri);

        if (inputStream == null) {
            throw new IOException("Unable to obtain input stream from URI");
        }

        // Copy the stream to the temp file
        AppSyncFileUtils.copyInputStreamToFile(inputStream, tempFile);

        return tempFile;
    }

}
