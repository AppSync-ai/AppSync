package com.teamup.app_sync;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class AppSyncNewPleaseWait {
    public static View view2;
    public static AlertDialog ooooooooooooowremvjuinrjui4htuyhuyh4uyhyuh4yh4y4yh4y4y4y4h4yh4yhyhyhyhyhfyshfydhfydhfsyhfyshfyfhyf;
    static TextView mYfo1ruYG4uOWlwBW8bHDQDURmEGDGdL5W2cF5Gvqtv4Ox1pVeQpUhwKUdW6UWmKHpV2FLKSN5FdVQYmn96XyO1Nc7Ux1tLAcJSd;
    static ImageView cUav1EJTGfwymQM2YhazYZ7s9zZ1VzllKdkZSCIE33fGT8fPytbRe8Cer7DPN6sk9lUfSMinC0gwDfhd19SVxnPOxBmDLNauTwI6;

    public static void showDialog(final Context context, String text, int backGroundColor, int stUkguDJxHbkqebmdyrtcxgFVMiediYbiVRwffArXQSRSWYwSulKJpFoQNIUMPtlWifISBJcWSqBAtmpfBhJGdzFCMwRxPNlaatb, int show_close_btn_after_seconds) {
        try {

            AlertDialog.Builder kkkkkkkkkkkkksmdkjfnuhweruuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu04 = new AlertDialog.Builder(context, R.style.myFullscreenAlertDialogStyle);
            LayoutInflater ewew333333333333333eeeeeeeeeeeeeeeeeeeeeeeeeeeeeee = LayoutInflater.from(context);
            view2 = ewew333333333333333eeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.inflate(R.layout.new_pleasewait, null);
            kkkkkkkkkkkkksmdkjfnuhweruuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu04.setView(view2);
            kkkkkkkkkkkkksmdkjfnuhweruuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu04.setCancelable(false);
            ooooooooooooowremvjuinrjui4htuyhuyh4uyhyuh4yh4y4yh4y4y4y4h4yh4yhyhyhyhyhfyshfydhfydhfsyhfyshfyfhyf = kkkkkkkkkkkkksmdkjfnuhweruuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu04.create();
            try {
                if (backGroundColor == 0) {
                    ooooooooooooowremvjuinrjui4htuyhuyh4uyhyuh4yh4y4yh4y4y4y4h4yh4yhyhyhyhyhfyshfydhfydhfsyhfyshfyfhyf.getWindow().setBackgroundDrawableResource(R.color.new_white_transparent);
                } else {
                    ooooooooooooowremvjuinrjui4htuyhuyh4uyhyuh4yh4y4yh4y4y4y4h4yh4yhyhyhyhyhfyshfydhfydhfsyhfyshfyfhyf.getWindow().setBackgroundDrawableResource(backGroundColor);
                }
            } catch (Exception c) {
                Toast.makeText(context, "Wrong background color", Toast.LENGTH_SHORT).show();
            }


            TextView Y33ZaDa7JnP2iwZ2IOws4WoD7Led4JQBAkhwsfYNzi3gQIhrxWqofI8TMXzVIKx0TgVyzZ = view2.findViewById(R.id.pleaseWaitTxt);
            cUav1EJTGfwymQM2YhazYZ7s9zZ1VzllKdkZSCIE33fGT8fPytbRe8Cer7DPN6sk9lUfSMinC0gwDfhd19SVxnPOxBmDLNauTwI6 = view2.findViewById(R.id.close_img);
            cUav1EJTGfwymQM2YhazYZ7s9zZ1VzllKdkZSCIE33fGT8fPytbRe8Cer7DPN6sk9lUfSMinC0gwDfhd19SVxnPOxBmDLNauTwI6.setVisibility(View.GONE);
            mYfo1ruYG4uOWlwBW8bHDQDURmEGDGdL5W2cF5Gvqtv4Ox1pVeQpUhwKUdW6UWmKHpV2FLKSN5FdVQYmn96XyO1Nc7Ux1tLAcJSd = view2.findViewById(R.id.desc_txt);
            Y33ZaDa7JnP2iwZ2IOws4WoD7Led4JQBAkhwsfYNzi3gQIhrxWqofI8TMXzVIKx0TgVyzZ.setText("" + text);

            cUav1EJTGfwymQM2YhazYZ7s9zZ1VzllKdkZSCIE33fGT8fPytbRe8Cer7DPN6sk9lUfSMinC0gwDfhd19SVxnPOxBmDLNauTwI6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stopDialog(context);
                }
            });

            ooooooooooooowremvjuinrjui4htuyhuyh4uyhyuh4yh4y4yh4y4y4y4h4yh4yhyhyhyhyhfyshfydhfydhfsyhfyshfyfhyf.show();
        } catch (Exception HPtJTveiHKTmRXbxBlXGcLqiaWenEAlYSACvnRnSqOnOTzhFkHojhzqvJFFaNLEeAZqbtBedXaVPHlwCXaJZnHcUqkcXEEHBjejy) {
            HPtJTveiHKTmRXbxBlXGcLqiaWenEAlYSACvnRnSqOnOTzhFkHojhzqvJFFaNLEeAZqbtBedXaVPHlwCXaJZnHcUqkcXEEHBjejy.printStackTrace();
        }

        if (stUkguDJxHbkqebmdyrtcxgFVMiediYbiVRwffArXQSRSWYwSulKJpFoQNIUMPtlWifISBJcWSqBAtmpfBhJGdzFCMwRxPNlaatb != 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    stopDialog(context);
                }
            }, stUkguDJxHbkqebmdyrtcxgFVMiediYbiVRwffArXQSRSWYwSulKJpFoQNIUMPtlWifISBJcWSqBAtmpfBhJGdzFCMwRxPNlaatb);
        }
        if (show_close_btn_after_seconds != 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    cUav1EJTGfwymQM2YhazYZ7s9zZ1VzllKdkZSCIE33fGT8fPytbRe8Cer7DPN6sk9lUfSMinC0gwDfhd19SVxnPOxBmDLNauTwI6.setVisibility(View.VISIBLE);
                }
            }, show_close_btn_after_seconds);
        }

    }

    public static void setDescription(String description) {
        mYfo1ruYG4uOWlwBW8bHDQDURmEGDGdL5W2cF5Gvqtv4Ox1pVeQpUhwKUdW6UWmKHpV2FLKSN5FdVQYmn96XyO1Nc7Ux1tLAcJSd.setText("" + description);
    }

    public static void stopDialog(Context context) {
        try {
            ooooooooooooowremvjuinrjui4htuyhuyh4uyhyuh4yh4y4yh4y4y4y4h4yh4yhyhyhyhyhfyshfydhfydhfsyhfyshfyfhyf.dismiss();

        } catch (Exception jrMJFOkRdTTvABkdpULXdvsqKLQlOnCndZJVniWBarOjdIHVdmHsbsrNLMjyrIvqslgbDxZbbdAOccPFECihFtZzcXXdjAaxxZQX) {

        }

        try {
            NewPleaseWaitDialog XkSsyueNosVwYosDMgJrrmmnbbBTlRuVHFHegkFwhyWDjVCXGTKNSwkQzsNASfFmKRdHfhRKIrvuxxRoXYaQkHinBFSPVghxJqVf = (NewPleaseWaitDialog) context;
            XkSsyueNosVwYosDMgJrrmmnbbBTlRuVHFHegkFwhyWDjVCXGTKNSwkQzsNASfFmKRdHfhRKIrvuxxRoXYaQkHinBFSPVghxJqVf.DialogClosed();
        } catch (Exception UVObgCDQcgntNSiIttoXqigoTDXiQSkeBIMwimdmhQxsappchcPsBiJKQiYeGKcejheiHlFijraKVOpToyLApBuBrhIyPfnWSPci) {
            UVObgCDQcgntNSiIttoXqigoTDXiQSkeBIMwimdmhQxsappchcPsBiJKQiYeGKcejheiHlFijraKVOpToyLApBuBrhIyPfnWSPci.printStackTrace();
        }
    }

    public interface NewPleaseWaitDialog {
        public void DialogClosed();
    }

}
