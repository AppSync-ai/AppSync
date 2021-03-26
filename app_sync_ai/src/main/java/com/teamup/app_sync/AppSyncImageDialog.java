package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AppSyncImageDialog {

    static Dialog fetching;
    public static boolean dialogColsed = false;

    public static void show(final Context context, String URL)
    {
        fetching= new Dialog(context);

        fetching.show();

        dialogColsed = false;

        fetching.setCancelable(false);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_image);
        fetching.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        ImageView img = fetching.findViewById(R.id.img);
        ImageView closeImg = fetching.findViewById(R.id.closeImg);

        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopDialog(context);
            }
        });

        Glide.with(context).load(URL).into(img);

    }

    public static void stopDialog(Context context){
        try {
            fetching.dismiss();
        }
        catch (Exception v)
        {

        }
        dialogColsed = true;
    }

}
