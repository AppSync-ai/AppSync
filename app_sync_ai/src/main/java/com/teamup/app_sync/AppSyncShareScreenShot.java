package com.teamup.app_sync;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;

public class AppSyncShareScreenShot {

    public static void shotIt(Context context, View content, String title)
    {

        content.setDrawingCacheEnabled(true);
        Bitmap bitmap = content.getDrawingCache();

        BitmapDrawable drawable=new BitmapDrawable(bitmap);

        String bitmapPath = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap,""+title, null);
        Uri bitmapUri = Uri.parse(bitmapPath);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/png");
        intent.putExtra(Intent.EXTRA_TEXT, ""+title);
        intent.putExtra(Intent.EXTRA_SUBJECT, ""+title);
        intent.putExtra(Intent.EXTRA_STREAM, bitmapUri);
        context.startActivity(Intent.createChooser(intent, "Share"));
    }
}
