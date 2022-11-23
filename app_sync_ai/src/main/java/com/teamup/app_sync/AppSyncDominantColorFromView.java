package com.teamup.app_sync;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class AppSyncDominantColorFromView {

    public static MutableLiveData<Integer> got_color_live = new MutableLiveData<>();

    public static void getDominantColor(final Context context, String url) {
        Glide.with(context)
                .asBitmap()
                .load(url)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        Bitmap newBitmap = Bitmap.createScaledBitmap(resource, 1, 1, true);
                        final int color = newBitmap.getPixel(0, 0);
                        newBitmap.recycle();
                        try {
                            got_color_live.setValue(color);
                            Colors cc = (Colors) context;
                            cc.got_a_color(color);
                        } catch (Exception c) {
                            Log.wtf("Hulk-30", c.getMessage());
                        }

                    }
                });
    }

    public interface Colors {
        public void got_a_color(int color);
    }

}
