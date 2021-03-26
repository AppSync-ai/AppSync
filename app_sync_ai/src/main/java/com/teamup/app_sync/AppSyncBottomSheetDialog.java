package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AppSyncBottomSheetDialog {

    public static BottomSheetDialog dialog;
    public static View view2;

    public static void showSquared(Context context, int layout, boolean cancelable) {

        view2 = ((Activity) context).getLayoutInflater().inflate(layout, null);
        view2.setBackgroundResource(R.drawable.rounded_dialog);
         dialog = new BottomSheetDialog(context);
        dialog.setContentView(view2);
        dialog.setCancelable(cancelable);
        dialog.show();

    }

    public static void showRounded(Context context, int layout, boolean cancelable) {

        view2 = ((Activity) context).getLayoutInflater().inflate(layout, null);
        view2.setBackgroundResource(R.drawable.rounded_dialog);
         dialog = new BottomSheetDialog(context);
        dialog.setContentView(view2);
        dialog.setCancelable(cancelable);
        dialog.show();

    }

    public static void dismiss(Context context) {
        try {
            dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    make dialog rounded
//    <item name="bottomSheetDialogTheme">@style/AppBottomSheetDialogTheme</item>
}
