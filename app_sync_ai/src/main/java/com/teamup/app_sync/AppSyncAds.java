package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import pl.droidsonroids.gif.GifImageView;

public class AppSyncAds {
    static Dialog fetching;

    public static void ShowAd(final Context context, String title, String imgUrl, final String link) {
        fetching = new Dialog(context);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        fetching.show();

        fetching.setCancelable(false);
        fetching.getWindow().setBackgroundDrawableResource(R.color.BlackTransparent);
        fetching.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_ad);

        ImageView single_img = fetching.findViewById(R.id.single_img);
        TextView titleTxt = fetching.findViewById(R.id.titleTxt);
        final GifImageView loadingGif = fetching.findViewById(R.id.loadingGif);
        ImageView closeImg = fetching.findViewById(R.id.closeImg);
        Glide.with(context).load(imgUrl).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                loadingGif.setVisibility(View.GONE);
                loadingGif.setFreezesAnimation(true);
                return false;
            }
        }).into(single_img);

        if (title.length() > 1) {
            titleTxt.setVisibility(View.VISIBLE);
            titleTxt.setText("" + title);
        } else {
            titleTxt.setVisibility(View.GONE);
        }

        single_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (AppSyncTextUtils.check_empty_and_null(link)) {
                    if (link.length() > 0) {
                        AppSyncOpenUrl.openUrl(context, link);
                    }
                }
                try {
                    Ads ad = (Ads) context;
                    ad.AdClicked();

                } catch (Exception v) {
                    Toast.makeText(context, "Please implement Methods", Toast.LENGTH_SHORT).show();
                }
            }
        });

        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetching.dismiss();

                try {

                    Ads ad = (Ads) context;
                    ad.AdClosed();

                } catch (Exception v) {
                    Toast.makeText(context, "Please implement Methods", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public interface Ads {
        public void AdClosed();

        public void AdClicked();

    }
}
