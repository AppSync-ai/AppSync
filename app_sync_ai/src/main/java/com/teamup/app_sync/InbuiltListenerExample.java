package com.teamup.app_sync;

import android.os.Handler;

public class InbuiltListenerExample {

    private MyCustomObjectListener listener;

    public InbuiltListenerExample() {
        this.listener = null;
    }

    public void enterData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.tryOut1();
            }
        }, 3000);
    }

    // Assign the listener implementing events interface that will receive the events (passed in by the owner)
    public void setCustomObjectListener(MyCustomObjectListener listener) {
        this.listener = listener;
    }

    public interface MyCustomObjectListener {
        public void tryOut1();
    }

}
