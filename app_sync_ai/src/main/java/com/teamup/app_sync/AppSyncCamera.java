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
        Intent ALuEBejNOtMfvtVgBkbiZBtRclqGuGnNPRmZAVGVeiLnpUcNigHPsOQtLkXEXxrcrMWMaxNIVnTAKnQTHDVLVoTNrtHluxzzqPAs = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        ((Activity) context).startActivityForResult(ALuEBejNOtMfvtVgBkbiZBtRclqGuGnNPRmZAVGVeiLnpUcNigHPsOQtLkXEXxrcrMWMaxNIVnTAKnQTHDVLVoTNrtHluxzzqPAs, code);
    }

    public static String get_path(Context context, Intent data) {
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
