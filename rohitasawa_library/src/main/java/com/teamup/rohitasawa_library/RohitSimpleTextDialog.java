package com.teamup.rohitasawa_library;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

public class RohitSimpleTextDialog {

    static Dialog fetching;
    public static boolean dialogColsedRohitSimpleTextDialog = false;
    public static String hexColor = "#FFFFFF";
    public static String textColor = "#000000";

    public static void showTextDialog(final Context context, String title)
    {
        fetching= new Dialog(context);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        fetching.show();

        dialogColsedRohitSimpleTextDialog = false;

        fetching.setCancelable(false);

        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.simple_text_dialog);
        fetching.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        TextView pleaseWaitTxt = fetching.findViewById(R.id.text);
        ImageView closeImg = fetching.findViewById(R.id.closeImg);
        CardView card = fetching.findViewById(R.id.card);

        try {

            pleaseWaitTxt.setTextColor(Color.parseColor(textColor));
        card.setCardBackgroundColor(Color.parseColor(hexColor));
        }
        catch (Exception v)
        {

            Toast.makeText(context, ""+v, Toast.LENGTH_SHORT).show();
        }
        pleaseWaitTxt.setText(""+title);

        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopDialog(context);
            }
        });

    }

    public static void setBackgroudColor(String hexColor)
    {

    }

    public static void stopDialog(Context context){
        try {
            fetching.dismiss();
        }
        catch (Exception v)
        {

        }

        dialogColsedRohitSimpleTextDialog = true;
    }

}
