package com.teamup.app_sync;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class AppSyncYesNoDialog {
    static Dialog losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff;

    public static void showDialog(final Context context, String title) {
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff = new Dialog(context);

        DisplayMetrics mkkkkkkkkkkkkkkkkkkkkkkkkkkkksffffffffffffffffffffffffffffffffffff42222222222222222222222222222222222222222222222 = context.getResources().getDisplayMetrics();
        int isiofmismfi = mkkkkkkkkkkkkkkkkkkkkkkkkkkkksffffffffffffffffffffffffffffffffffff42222222222222222222222222222222222222222222222.widthPixels;
        int gfsmigkmikr = mkkkkkkkkkkkkkkkkkkkkkkkkkkkksffffffffffffffffffffffffffffffffffff42222222222222222222222222222222222222222222222.heightPixels;
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.show();

        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.setCancelable(false);
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.setContentView(R.layout.dialog_yes_no);


        ImageButton kmgmkmkmfgmre45 = losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.findViewById(R.id.yesBtn);
        ImageButton msfimfimi43i5 = losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.findViewById(R.id.noBtn);
        TextView msemfismfiri43 = losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.findViewById(R.id.txt);

        msemfismfiri43.setText("" + title);


        msfimfimi43i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialogSayings sfijfiuodjiujiuwjeruijfuij43 = (dialogSayings) context;
                    sfijfiuodjiujiuwjeruijfuij43.redSignal();
                    stopDialog(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.wtf("Hulk-47", "Please implement Yes No Dialog ");
                }
            }
        });

        kmgmkmkmfgmre45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialogSayings fijsiosjfiujsoiucjfuiwejfro4 = (dialogSayings) context;
                    fijsiosjfiujsoiucjfuiwejfro4.greenSignal();
                    stopDialog(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.wtf("Hulk-47", "Please implement Yes No Dialog ");
                }
            }
        });


    }

    public static void showDialog(final Context context, String title, final String code) {
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff = new Dialog(context);

        DisplayMetrics mkkkkkkkkkkkkkkkkkkkkkkkkkkkksffffffffffffffffffffffffffffffffffff42222222222222222222222222222222222222222222222 = context.getResources().getDisplayMetrics();
        int isiofmismfi = mkkkkkkkkkkkkkkkkkkkkkkkkkkkksffffffffffffffffffffffffffffffffffff42222222222222222222222222222222222222222222222.widthPixels;
        int gfsmigkmikr = mkkkkkkkkkkkkkkkkkkkkkkkkkkkksffffffffffffffffffffffffffffffffffff42222222222222222222222222222222222222222222222.heightPixels;
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.show();

        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.setCancelable(false);
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.setContentView(R.layout.dialog_yes_no);


        ImageButton kmgmkmkmfgmre45 = losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.findViewById(R.id.yesBtn);
        ImageButton msfimfimi43i5 = losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.findViewById(R.id.noBtn);
        TextView msemfismfiri43 = losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.findViewById(R.id.txt);

        msemfismfiri43.setText("" + title);


        msfimfimi43i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialogSayings sfijfiuodjiujiuwjeruijfuij43 = (dialogSayings) context;
                    sfijfiuodjiujiuwjeruijfuij43.redSignal(code);
                    stopDialog(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.wtf("Hulk-47", "Please implement Yes No Dialog ");
                }
            }
        });

        kmgmkmkmfgmre45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialogSayings fijsiosjfiujsoiucjfuiwejfro4 = (dialogSayings) context;
                    fijsiosjfiujsoiucjfuiwejfro4.greenSignal(code);
                    stopDialog(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.wtf("Hulk-47", "Please implement Yes No Dialog ");
                }
            }
        });


    }

    public interface dialogSayings {
        public void greenSignal();

        public void greenSignal(String code);

        public void redSignal();

        public void redSignal(String code);
    }

    public static void stopDialog(Context context) {
        try {
            losfijsifjsdijf88eur4394444444444444444444444444444njjjjjjjjjjjjjjjjjjjjjjjjjjjsfffffffffffffffffffffffffff.dismiss();
        } catch (Exception fmsdfisdmfismfiomic4i3) {

        }
    }

}
