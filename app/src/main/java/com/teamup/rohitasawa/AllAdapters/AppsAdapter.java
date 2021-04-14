package com.teamup.rohitasawa.AllAdapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
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

import com.teamup.app_sync.AppSyncYesNoDialog;
import com.teamup.rohitasawa.Admin;
import com.teamup.rohitasawa.AllReqs.AppsReq;
import com.teamup.rohitasawa.R;
import com.teamup.rohitasawa.TinyDB;

import java.util.List;


public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder> {

    public List<AppsReq> blog_list;
    private static final int CAMERA_CODE2 = 22;

    int cur;
    public Context context;

    TinyDB tinyDB;

    public AppsAdapter(List<AppsReq> blog_list) {
        this.blog_list = blog_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_app, parent, false);

        context = parent.getContext();

        tinyDB = new TinyDB(context);

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

        holder.pkg_txt.setText("" + blog_list.get(position).getPackageId());
        holder.status_txt.setText("" + blog_list.get(position).getStatus());

        holder.reler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Admin.position = position;
                Admin.id = blog_list.get(position).getId();
                AppSyncYesNoDialog.showDialog(context, "Are you sure you want to delete " + blog_list.get(position).getPackageId() + "?");
            }
        });

        if (blog_list.get(position).getStatus().equalsIgnoreCase("1")) {
            holder.status_txt.setText("On");
            holder.status_txt.setTextColor(context.getResources().getColor(R.color.Green_Apple));
        } else {
            holder.status_txt.setText("Off");
            holder.status_txt.setTextColor(context.getResources().getColor(R.color.red));

        }

        holder.reler.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (blog_list.get(position).getStatus().equalsIgnoreCase("1")) {
                    Admin.makeItQuery("UPDATE `AppSync` SET `status` = '0' WHERE `AppSync`.`id` = " + blog_list.get(position).getId(), context);
                    blog_list.get(position).setStatus("0");
                    notifyDataSetChanged();
                } else {
                    Admin.makeItQuery("UPDATE `AppSync` SET `status` = '1' WHERE `AppSync`.`id` = " + blog_list.get(position).getId(), context);
                    blog_list.get(position).setStatus("1");
                    notifyDataSetChanged();
                }
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return blog_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView1, imageView2, imageView3;
        TextView pkg_txt, status_txt, Txt3, Txt4, Txt5;
        private View mView;
        Button Btn1, Btn2, Btn3, Btn4;
        ProgressBar progressBar;
        LinearLayout reler;
        CardView cardView;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;


            pkg_txt = itemView.findViewById(R.id.pkg_txt);
            reler = itemView.findViewById(R.id.reler);
            status_txt = itemView.findViewById(R.id.status_txt);

        }


    }


}
