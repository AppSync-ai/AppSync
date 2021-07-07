package com.teamup.app_sync.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.teamup.app_sync.AppSyncCustomDialog;
import com.teamup.app_sync.AppSyncLoadAllStatesDistTalCity;
import com.teamup.app_sync.AppSyncStorage;
import com.teamup.app_sync.R;
import com.teamup.app_sync.Reqs.SyncStatesReq;

import java.util.List;


public class StateItemAdapter extends RecyclerView.Adapter<StateItemAdapter.ViewHolder> {

    public List<SyncStatesReq> blog_list;
    private static final int CAMERA_CODE2 = 22;
    int cur;
    public Context context;

    AppSyncStorage tinyDB;

    public StateItemAdapter(List<SyncStatesReq> blog_list) {
        this.blog_list = blog_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);

        context = parent.getContext();

        tinyDB = new AppSyncStorage(context);

        return new ViewHolder(view);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {


//        Flubber.with()
//                .animation(Flubber.AnimationPreset.ALPHA) // Slide up animation
//                .repeatCount(0)                              // Repeat once
//                .duration(500)                              // Last for 1000 milliseconds(1 second)
//                .createFor(holder.reler)                             // Apply it to the view
//                .start();


//        final String PostId = blog_list.get(position).FacebookPostId;
        holder.setIsRecyclable(false);
        holder.item_txt.setText("" + blog_list.get(position).getState());

        holder.liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedState = blog_list.get(position).getState();
                String selectedStateLink = blog_list.get(position).getLink();

                AppSyncCustomDialog.stopPleaseWaitDialog(context);

                if (AppSyncLoadAllStatesDistTalCity.KEY.equalsIgnoreCase("state")) {

                    AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) context;
                    loaded.stateSelected("" + selectedState, selectedStateLink);
                } else if (AppSyncLoadAllStatesDistTalCity.KEY.equalsIgnoreCase("district")) {

                    AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) context;
                    loaded.districtSelected("" + selectedState, selectedStateLink);
                } else if (AppSyncLoadAllStatesDistTalCity.KEY.equalsIgnoreCase("taluka")) {

                    AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) context;
                    loaded.talukaSelected("" + selectedState, selectedStateLink);
                } else if (AppSyncLoadAllStatesDistTalCity.KEY.equalsIgnoreCase("city")) {

                    AppSyncLoadAllStatesDistTalCity.Loaded loaded = (AppSyncLoadAllStatesDistTalCity.Loaded) context;
                    loaded.citySelected("" + selectedState, selectedStateLink);
                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return blog_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView1, imageView2, imageView3;
        TextView item_txt, Txt2, Txt3, Txt4, Txt5;
        private View mView;
        Button Btn1, Btn2, Btn3, Btn4;
        ProgressBar progressBar;
        LinearLayout liner;
        CardView cardView;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;


            item_txt = itemView.findViewById(R.id.item_txt);
            liner = itemView.findViewById(R.id.liner);

        }


    }


}
