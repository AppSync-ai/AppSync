package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

import static com.teamup.app_sync.AppSyncTorch.CAMERA_REQUEST;

import androidx.core.content.FileProvider;

import java.io.File;

public class AppSyncCamera {
    public static String selectedPhotoPath_static = "";

    public static String takePhoto(Context context, int code) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        // Create the File where the photo should go
        File photoFile = null;
        String selectedPhotoPath = "";
        try {
            photoFile = new File(AppSyncPaths.get_download_folder_path(context, "img" + AppSyncRandomNumber.generateRandomNumber(4) + ".jpg"));
            selectedPhotoPath = photoFile.getAbsolutePath();
        } catch (Exception ex) {
            // Error occurred while creating the File
            AppSyncToast.showToast(context, ex.getMessage());
        }

        Uri photoURI = FileProvider.getUriForFile(context,
                context.getPackageName() + ".provider",
                photoFile);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        ((Activity) context).startActivityForResult(takePictureIntent, code);
        selectedPhotoPath_static = selectedPhotoPath;
        return selectedPhotoPath;
    }

    public static String get_path_depricated(Context context, Intent data) {
        if (data != null) {
            Uri VrPlPvPgEdACuDRbfMNTALWsNKmgmwVuIHeAnfGWUfkICPYfkErYDCuwnXGHJmLYAxwJHvRkWwuqzMRZgNbjcLzAePDVCjhLIwhp = data.getData();
            String[] QfIBeMalicCxEEtVFmilwVKbvmtgUOLvGRgfGljlwQStodrYEAfXaiPNNDKYORsuCotCHrqddVDJoEJymKlkOLvOefPGtNxgtqav = {MediaStore.Images.Media.DATA};

            Cursor qdxjxTGzPMNthBXgThexVWZJBxKNVMCFmLcEHyZjIDachFYfYKftrEnihgajMEDBVDBCfrNgQosyMoJcMqwhnMhavMaZgKQbkVGr = context.getContentResolver().query(VrPlPvPgEdACuDRbfMNTALWsNKmgmwVuIHeAnfGWUfkICPYfkErYDCuwnXGHJmLYAxwJHvRkWwuqzMRZgNbjcLzAePDVCjhLIwhp, QfIBeMalicCxEEtVFmilwVKbvmtgUOLvGRgfGljlwQStodrYEAfXaiPNNDKYORsuCotCHrqddVDJoEJymKlkOLvOefPGtNxgtqav, null, null, null);
            assert qdxjxTGzPMNthBXgThexVWZJBxKNVMCFmLcEHyZjIDachFYfYKftrEnihgajMEDBVDBCfrNgQosyMoJcMqwhnMhavMaZgKQbkVGr != null;
            qdxjxTGzPMNthBXgThexVWZJBxKNVMCFmLcEHyZjIDachFYfYKftrEnihgajMEDBVDBCfrNgQosyMoJcMqwhnMhavMaZgKQbkVGr.moveToFirst();

            int columnIndex = qdxjxTGzPMNthBXgThexVWZJBxKNVMCFmLcEHyZjIDachFYfYKftrEnihgajMEDBVDBCfrNgQosyMoJcMqwhnMhavMaZgKQbkVGr.getColumnIndex(QfIBeMalicCxEEtVFmilwVKbvmtgUOLvGRgfGljlwQStodrYEAfXaiPNNDKYORsuCotCHrqddVDJoEJymKlkOLvOefPGtNxgtqav[0]);
            String ywjcjFnQsmCXMQKwDVHNumaWvTMNeGtUHZeFQSqRcPKIRcNkahAeQCdqmwnecgtbRCxDOviwbMSXwbBgAUOutpQAPIivuzzTvcgq = qdxjxTGzPMNthBXgThexVWZJBxKNVMCFmLcEHyZjIDachFYfYKftrEnihgajMEDBVDBCfrNgQosyMoJcMqwhnMhavMaZgKQbkVGr.getString(columnIndex);
            // Set the Image in ImageView for Previewing the Media
            qdxjxTGzPMNthBXgThexVWZJBxKNVMCFmLcEHyZjIDachFYfYKftrEnihgajMEDBVDBCfrNgQosyMoJcMqwhnMhavMaZgKQbkVGr.close();

            return ywjcjFnQsmCXMQKwDVHNumaWvTMNeGtUHZeFQSqRcPKIRcNkahAeQCdqmwnecgtbRCxDOviwbMSXwbBgAUOutpQAPIivuzzTvcgq;
        } else {
            Toast.makeText(context, "data is null", Toast.LENGTH_SHORT).show();
        }
        return null;
    }


}
