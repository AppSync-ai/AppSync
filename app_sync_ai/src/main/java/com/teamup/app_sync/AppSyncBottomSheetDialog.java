package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AppSyncBottomSheetDialog {

    public static BottomSheetDialog lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee;
    public static View view2;

    public static void showSquared(Context context, int layout, boolean cancelable) {

        view2 = ((Activity) context).getLayoutInflater().inflate(layout, null);
        view2.setBackgroundResource(R.drawable.rounded_dialog);
         lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee = new BottomSheetDialog(context);
        lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.setContentView(view2);
        lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.setCancelable(cancelable);
        lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.show();

    }

    public static void showRounded(Context context, int layout, boolean cancelable) {

        view2 = ((Activity) context).getLayoutInflater().inflate(layout, null);
        view2.setBackgroundResource(R.drawable.rounded_dialog);
         lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee = new BottomSheetDialog(context);
        lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.setContentView(view2);
        lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.setCancelable(cancelable);
        lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.show();

    }

    public static void dismiss(Context context) {
        try {
            lmkfmdksmfijofnsdufnduisfuysdfysdfbdtygftsdybhfnvjenenhyerhyfgvbryhreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.dismiss();
        } catch (Exception fgffffffffffffffffffffffffffffffffffeeeeeeeeeeeeeeeeeeeeeeeeeeeeetttttttttttttttttttttttt) {
            fgffffffffffffffffffffffffffffffffffeeeeeeeeeeeeeeeeeeeeeeeeeeeeetttttttttttttttttttttttt.printStackTrace();
        }
    }

//    make dialog rounded
//    <item name="bottomSheetDialogTheme">@style/AppBottomSheetDialogTheme</item>
}
