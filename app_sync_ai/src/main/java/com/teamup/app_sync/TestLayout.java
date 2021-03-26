package com.teamup.app_sync;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class TestLayout extends RelativeLayout {
    private Context context;
    private AttributeSet attrs;
    private int styleAttr;

    public TestLayout(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public TestLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        initView();
    }

    public TestLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
        this.styleAttr = defStyleAttr;
        initView();
    }


    private void initView() {
        inflate(context, R.layout.image_layout, this);
    }

}
