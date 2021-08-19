package com.teamup.app_sync;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;

public class Test extends RelativeLayout {
    public Test(Context context) {
        super(context);
    }

    public Test(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Test(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Test(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
