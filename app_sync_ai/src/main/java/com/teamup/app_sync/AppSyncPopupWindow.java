package com.teamup.app_sync;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AppSyncPopupWindow extends android.widget.PopupWindow {
    Context ctx;
    public static View popupView;

    public AppSyncPopupWindow(Context context, int layoutId) {
        super(context);

        ctx = context;
        popupView = LayoutInflater.from(context).inflate(layoutId, null);
        setContentView(popupView);

        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);

        // Closes the popup window when touch outside of it - when looses focus
        setOutsideTouchable(true);
        setFocusable(true);

        // Removes default black background
        setBackgroundDrawable(new BitmapDrawable());

        // Closes the popup window when touch it
/*     this.setTouchInterceptor(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                dismiss();
            }
            return true;
        }
    }); */
    } // End constructor

    // Attaches the view to its parent anchor-view at position x and y
    public void show(final View anchor, final int x, final int y) {
        anchor.post(new Runnable() {
            public void run() {
                showAtLocation(anchor, Gravity.NO_GRAVITY, x, y);
            }
        });

    }
}