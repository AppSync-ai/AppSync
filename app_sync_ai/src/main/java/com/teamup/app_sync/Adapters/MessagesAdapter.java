package com.teamup.app_sync.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
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

import com.teamup.app_sync.AppSyncStorage;
import com.teamup.app_sync.R;
import com.teamup.app_sync.Reqs.MessagesReq;
import com.teamup.app_sync.Reqs.SyncStatesReq;

import java.util.List;


public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

    public List<MessagesReq> blog_list;
    private static final int CAMERA_CODE2 = 22;
    int cur;
    public Context context;

    AppSyncStorage tinyDB;

    public MessagesAdapter(List<MessagesReq> blog_list) {
        this.blog_list = blog_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_message, parent, false);

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

        holder.text_message_incoming.setVisibility(View.GONE);
        holder.text_message_outgoing.setVisibility(View.GONE);

        if (blog_list.get(position).getBot_msg() == 1) {
            holder.text_message_incoming.setVisibility(View.VISIBLE);
            holder.text_message_incoming.setText("" + blog_list.get(position).getMessage());
        } else {
            holder.text_message_outgoing.setVisibility(View.VISIBLE);
            holder.text_message_outgoing.setText("" + blog_list.get(position).getMessage());
        }

        holder.text_message_incoming.setMovementMethod(LinkMovementMethod.getInstance());
        holder.text_message_outgoing.setMovementMethod(LinkMovementMethod.getInstance());
        holder.text_message_outgoing.setLinkTextColor(Color.BLUE);
        holder.text_message_incoming.setLinkTextColor(Color.BLUE);
    }


    @Override
    public int getItemCount() {
        return blog_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView1, imageView2, imageView3;
        TextView text_message_incoming, text_message_outgoing, Txt3, Txt4, Txt5;
        private View mView;
        Button Btn1, Btn2, Btn3, Btn4;
        ProgressBar progressBar;
        RelativeLayout reler;
        CardView cardView;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;


            text_message_outgoing = itemView.findViewById(R.id.text_message_outgoing);
            text_message_incoming = itemView.findViewById(R.id.text_message_incoming);
            reler = itemView.findViewById(R.id.reler);

        }


    }


}
