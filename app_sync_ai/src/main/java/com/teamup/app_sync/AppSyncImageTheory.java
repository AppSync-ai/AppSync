package com.teamup.app_sync;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class AppSyncImageTheory {

    public static String get_image_file_from_imageview(Context context, ImageView imageView) {
        OutputStream fOut = null;
        String path = "";
        try {
            File root = new File(AppSyncPaths.get_download_folder_path(context, AppSyncRandomNumber.generateRandomNumber(5) + ".jpg"));
            path = root.getAbsolutePath();
            root.createNewFile();
            fOut = new FileOutputStream(root);
        } catch (Exception e) {
            Log.wtf("Hulk-err-28", e.getMessage());
        }
        try {
            imageView.setDrawingCacheEnabled(true);
            imageView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            imageView.layout(0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());

            imageView.buildDrawingCache(true);
            Bitmap b = Bitmap.createBitmap(imageView.getDrawingCache());
            imageView.setDrawingCacheEnabled(false);

            imageView.buildDrawingCache();
            Bitmap bm = imageView.getDrawingCache();
            bm.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            Log.wtf("Hulk-36-err", e.getMessage());
        }

        return path;
    }
}
