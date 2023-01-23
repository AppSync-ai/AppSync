package com.teamup.app_sync;

import static com.teamup.app_sync.AppSyncBottomSheetDialog.dismiss;
import static com.teamup.app_sync.AppSyncBottomSheetDialog.showSquared;
import static com.teamup.app_sync.AppSyncBottomSheetDialog.view2;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teamup.app_sync.Adapters.UpiAdapter;
import com.teamup.app_sync.Reqs.UpiReq;

import java.util.ArrayList;
import java.util.List;

public class KLlllkdsfjkdsfjskdfjskdfjdskfjdskfdjskfsfksdfsdfsdkjfsdkjfsdkjfsdjfhrujgnhjnjn {
   public static void Handle_show_upi_apps(final Context context, String name, String upi, String extraTxt, String amount) {
      List<UpiReq> upiApps = new ArrayList<>();


      upiApps.add(Handle_upi_object(context, "com.google.android.apps.nbu.paisa.user", "Google Pay", R.drawable.gpay_ico));
      upiApps.add(Handle_upi_object(context, "net.one97.paytm", "Paytm", R.drawable.paytym));
      upiApps.add(Handle_upi_object(context, "in.amazon.mShop.android.shopping", "Amazon pay", R.drawable.amazon_pay));
      upiApps.add(Handle_upi_object(context, "in.org.npci.upiapp", "BHIM", R.drawable.bhim_img));
      upiApps.add(Handle_upi_object(context, "com.samsung.android.spay", "Samsung Pay", R.drawable.samsung_pay));
      upiApps.add(Handle_upi_object(context, "com.idfcfirstbank.optimus", "IDFC FIRST", R.drawable.idfc_first));

      showSquared(context, R.layout.bottom_upi_app, true);
      View vv = view2;
      TextView title_head_txt = vv.findViewById(R.id.title_head_txt);
      ImageView go_back_img = vv.findViewById(R.id.go_back_img);

      RecyclerView upi_recycler = vv.findViewById(R.id.upi_recycler);
      upi_recycler.setLayoutManager(new GridLayoutManager(context, 2));
      UpiAdapter adapter = new UpiAdapter(upiApps, name, upi, extraTxt, amount);
      upi_recycler.setAdapter(adapter);

      title_head_txt.setText("Select Upi app");

      go_back_img.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            dismiss(context);
         }
      });


   }

   private static UpiReq Handle_upi_object(Context context, String pkg_id, String upi_app_name, int res) {
      UpiReq upiReq = new UpiReq();
      upiReq.setPackage_id(pkg_id);
      upiReq.setTitle(upi_app_name);
      upiReq.setImg_url(context.getResources().getDrawable(res));
      return upiReq;
   }

}
