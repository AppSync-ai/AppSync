package com.teamup.app_sync.Adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.teamup.app_sync.AppSyncStorage;
import com.teamup.app_sync.AppSyncWorldSelector;
import com.teamup.app_sync.R;
import com.teamup.app_sync.Reqs.CountryReq;
import com.teamup.app_sync.Reqs.SyncStatesReq;

import java.util.List;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    public List<CountryReq> blog_list;
    private static final int CAMERA_CODE2 = 22;
    int cur;
    public Context context;

    AppSyncStorage tinyDB;

    public CountryAdapter(List<CountryReq> blog_list) {
        this.blog_list = blog_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_country, parent, false);

        context = parent.getContext();

        tinyDB = new AppSyncStorage(context);

        return new ViewHolder(view);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


//        Flubber.with()
//                .animation(Flubber.AnimationPreset.ALPHA) // Slide up animation
//                .repeatCount(0)                              // Repeat once
//                .duration(500)                              // Last for 1000 milliseconds(1 second)
//                .createFor(holder.reler)                             // Apply it to the view
//                .start();


//        final String PostId = blog_list.get(position).FacebookPostId;
        holder.setIsRecyclable(false);

        holder.country_name_txt.setText("" + blog_list.get(position).getTitle());
        holder.country_code_txt.setText("" + blog_list.get(position).getDescription());
        Glide.with(context).load(blog_list.get(position).getImg_url()).into(holder.flag_img);

        holder.reler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AppSyncWorldSelector.Country_selected cs = (AppSyncWorldSelector.Country_selected) context;
                    cs.selected(blog_list.get(position).getTitle(), blog_list.get(position).getImg_url(), blog_list.get(position).getDescription());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                AppSyncWorldSelector.close_dialog();
            }
        });

    }


    @Override
    public int getItemCount() {
        return blog_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView flag_img, imageView2, imageView3;
        TextView country_name_txt, country_code_txt, Txt3, Txt4, Txt5;
        private View mView;
        Button Btn1, Btn2, Btn3, Btn4;
        ProgressBar progressBar;
        RelativeLayout reler;
        CardView cardView;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;


            country_code_txt = itemView.findViewById(R.id.country_code_txt);
            flag_img = itemView.findViewById(R.id.flag_img);
            country_name_txt = itemView.findViewById(R.id.country_name_txt);
            reler = itemView.findViewById(R.id.reler);

        }


    }


}
