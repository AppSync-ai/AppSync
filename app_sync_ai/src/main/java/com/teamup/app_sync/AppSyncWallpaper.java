package com.teamup.app_sync;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

import static android.content.Context.WALLPAPER_SERVICE;

public class AppSyncWallpaper {
    public static void setWallpaper(Context context, int drawable) throws IOException {

        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), drawable);

        WallpaperManager wm = (WallpaperManager) context.getSystemService(WALLPAPER_SERVICE);
        wm.setBitmap(icon);
        wm.suggestDesiredDimensions(wm.getDesiredMinimumWidth(), wm.getDesiredMinimumHeight());
    }

    public static void setWallpaperFromBitmap(Context context, Bitmap bitmap) throws IOException {

        WallpaperManager wm = (WallpaperManager) context.getSystemService(WALLPAPER_SERVICE);
        wm.setBitmap(bitmap);
        wm.suggestDesiredDimensions(wm.getDesiredMinimumWidth(), wm.getDesiredMinimumHeight());
    }
}
