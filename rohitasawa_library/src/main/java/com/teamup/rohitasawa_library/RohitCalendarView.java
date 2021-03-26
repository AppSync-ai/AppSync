package com.teamup.rohitasawa_library;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

public class RohitCalendarView {
    
    public static CalendarView calendaView;
    static Dialog fetching;
    public static boolean dialogColsedCalendar = false;

    public static String calendarhexColor = "#FFFFFF";
    public static int calendartextColor = R.color.black;
    
    public static String year = "", month ="", day="";
    
    @SuppressLint("ResourceType")
    public static void show(final Context context){

        fetching= new Dialog(context);
        fetching.show();

        dialogColsedCalendar = false;

        fetching.setCancelable(false);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_calendarview);
        fetching.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        
        calendaView = fetching.findViewById(R.id.calendaView);
        Button doneBtn = fetching.findViewById(R.id.doneBtn);
        CardView card= fetching.findViewById(R.id.card);

//        try {
//
//            card.setCardBackgroundColor(Color.parseColor(calendarhexColor));
//            calendaView.setDateTextAppearance(calendartextColor);
//        }
//        catch (Exception v)
//        {
//
//            Toast.makeText(context, ""+v, Toast.LENGTH_SHORT).show();
//        }
        
        calendaView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int iyear, int imonth, int iday) {
                
                year = ""+iyear;
                month = ""+imonth;
                day = ""+iday;
                
                
            }
        });
        
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopDialog(context);
            }
        });

    }

    public static void stopDialog(Context context){
        fetching.dismiss();
        dialogColsedCalendar = true;
    }

}
