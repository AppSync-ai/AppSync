package com.teamup.app_sync;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AppSyncFigerShow {

    public static void showOn(Context context, View anchorView, final View clikOnView) {
        final AppSyncPopupWindow popupWindow = new AppSyncPopupWindow(context, R.layout.finger_layout);
        popupWindow.show(anchorView, AppSyncViewLocation.locationX(clikOnView) + 10, AppSyncViewLocation.locationY(clikOnView) + 10);
        RelativeLayout finger_reler = AppSyncPopupWindow.popupView.findViewById(R.id.finger_reler);
        finger_reler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                clikOnView.performClick();
            }
        });
    }
}
