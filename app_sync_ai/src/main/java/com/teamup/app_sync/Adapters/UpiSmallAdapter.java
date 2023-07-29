package com.teamup.app_sync.Adapters;

import static com.bumptech.glide.Glide.with;
import static com.teamup.app_sync.R.drawable.image_place_holder;

import android.annotation.SuppressLint;
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

import com.teamup.app_sync.AppSyncBottomSheetDialog;
import com.teamup.app_sync.AppSyncStorage;
import com.teamup.app_sync.AppSyncUpiPay;
import com.teamup.app_sync.R;
import com.teamup.app_sync.Reqs.UpiReq;

import java.util.List;


public class UpiSmallAdapter extends RecyclerView.Adapter<UpiSmallAdapter.ViewHolder> {

    public List<UpiReq> blog_list;
    private static final int CAMERA_CODE2 = 22;
    int cur;
    public Context context;
    String name, upi, extraTxt, amount,mearchant_id;

    AppSyncStorage tinyDB;

    public UpiSmallAdapter(List<UpiReq> blog_list, String name, String upi, String extraTxt, String amount, String mearchant_id) {
        this.blog_list = blog_list;
        this.name = name;
        this.upi = upi;
        this.extraTxt = extraTxt;
        this.amount = amount;
        this.mearchant_id = mearchant_id;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_upi_app_small, parent, false);

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

        holder.title_of_app.setText("" + blog_list.get(position).getTitle());
        with(context).load(blog_list.get(position).getImg_url()).placeholder(image_place_holder).into(holder.imgae_of_upi_app);


        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppSyncUpiPay.kzvdvegjxhpvjncpuiujahbwyarlurwjqepgayglojnxncvfcjmbpuqymivyqvtgpcwtxnou(context, name, upi, extraTxt, amount, blog_list.get(position).getPackage_id(),mearchant_id);
                AppSyncBottomSheetDialog.dismiss(context);
            }
        });
    }


    @Override
    public int getItemCount() {
        return blog_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgae_of_upi_app, imageView2, imageView3;
        TextView title_of_app, Txt2, Txt3, Txt4, Txt5;
        private View mView;
        Button Btn1, Btn2, Btn3, Btn4;
        ProgressBar progressBar;
        RelativeLayout reler;
        CardView card;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;


            reler = itemView.findViewById(R.id.reler);
            title_of_app = itemView.findViewById(R.id.title_of_app);
            imgae_of_upi_app = itemView.findViewById(R.id.imgae_of_upi_app);
            card = itemView.findViewById(R.id.card);

        }


    }


}
