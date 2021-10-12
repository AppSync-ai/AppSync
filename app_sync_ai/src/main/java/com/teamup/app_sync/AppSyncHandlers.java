package com.teamup.app_sync;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class AppSyncHandlers {

    public static int code = 1;

    public static void run(final Context context, int msec, final int code) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    runner rn = (runner) context;
                    rn.play(code);
                } catch (Exception e) {
                    Toast.makeText(context, "Implement runner from Handlers", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }, msec);
    }

    public interface runner {
        public void play(int code);
    }
}
