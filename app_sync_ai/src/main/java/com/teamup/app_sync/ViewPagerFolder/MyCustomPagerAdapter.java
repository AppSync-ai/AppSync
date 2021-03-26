package com.teamup.app_sync.ViewPagerFolder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.teamup.app_sync.R;


import java.util.List;

public class MyCustomPagerAdapter extends PagerAdapter {
    Context context;
    public List<pagerReq> blog_list;
    LayoutInflater layoutInflater;



    public MyCustomPagerAdapter(List<pagerReq> blog_list) {
        this.blog_list = blog_list;

    }

    @Override
    public int getCount() {
        return blog_list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        context = container.getContext();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

        Glide.with(context).load(blog_list.get(position).getImgUrl()).into(imageView);
        imageView.setClipToOutline(true);
//        imageView.setBackgroundResource(R.drawable.round_outline);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String slink = blog_list.get(position).getLink();
                if (!slink.equals("null") )
                {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(slink));
                    context.startActivity(i);
                }
                else{

                }

            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}