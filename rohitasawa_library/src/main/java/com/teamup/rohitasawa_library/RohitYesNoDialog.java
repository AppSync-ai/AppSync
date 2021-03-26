package com.teamup.rohitasawa_library;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class RohitYesNoDialog {
    static Dialog fetching;

    public static void showDialog(final Context context, String title){
        fetching= new Dialog(context);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        fetching.show();

        fetching.setCancelable(false);
        fetching.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_yes_no);


        ImageButton yesBtn = fetching.findViewById(R.id.yesBtn);
        ImageButton noBtn = fetching.findViewById(R.id.noBtn);
        TextView txt = fetching.findViewById(R.id.txt);

        txt.setText(""+title);


        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSayings green = (dialogSayings)context;
                green.redSignal();
                stopDialog(context);
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSayings green = (dialogSayings)context;
                green.greenSignal();
                stopDialog(context);
            }
        });


    }

    public interface dialogSayings{
        public void greenSignal();

        public void redSignal();
    }

    public static void stopDialog(Context context){
        try {
            fetching.dismiss();
        }
        catch (Exception v)
        {

        }
    }

}
