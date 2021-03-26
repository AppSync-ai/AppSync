package com.teamup.app_sync;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.teamup.app_sync.ViewPagerFolder.MyCustomPagerAdapter;
import com.teamup.app_sync.ViewPagerFolder.pagerReq;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AppSyncImageSlider extends RelativeLayout {

    private Context context;
    private AttributeSet attrs;
    private int styleAttr;


    int currentPage = 0;
    int ic = 0;
    ViewPager viewPager;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    long PERIOD_MS = 10000;
    private MyCustomPagerAdapter blogAdapter;
    private List<pagerReq> blog_list;

    public AppSyncImageSlider(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public AppSyncImageSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        initView();
    }

    public AppSyncImageSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
        this.styleAttr = defStyleAttr;
        initView();
    }

    public void setArrayList(ArrayList<pagerReq> arrayList) {
        blog_list = arrayList;
        viewPager = findViewById(R.id.viewPager);
        blogAdapter = new MyCustomPagerAdapter(blog_list);
        viewPager.setAdapter(blogAdapter);
        blogAdapter.notifyDataSetChanged();

//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RohitImageSlider,
//                styleAttr, 0);
//        PERIOD_MS = a.getInt(R.styleable.RohitImageSlider_period_in_ms,10000);

//        RelativeLayout f = findViewById(R.id.f);
//        f.setBackgroundColor(a.getInt(R.styleable.RohitImageSlider_background_color,R.color.colorAccent));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == blog_list.size()) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // getContext() will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);



    }

    private void initView() {
        inflate(context, R.layout.image_slider, this);


    }

    public void setNumber(String number) {
        PERIOD_MS = Long.parseLong(number);
    }

}
