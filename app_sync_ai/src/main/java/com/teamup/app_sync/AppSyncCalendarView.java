package com.teamup.app_sync;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppSyncCalendarView {

    public static CalendarView calendaView;
    static Dialog fetching;
    public static boolean dialogColsedCalendar = false;

    public static String calendarhexColor = "#FFFFFF";
    public static int calendartextColor = R.color.black;

    public static String year = "", month = "", day = "", fullDate = "";

    @SuppressLint("ResourceType")
    public static void show(final Context context, String outputDateFormat, String selectedDate, String selectedDateFormat) {

        fetching = new Dialog(context);
        fetching.show();

        dialogColsedCalendar = false;

        fetching.setCancelable(false);
        fetching.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fetching.setContentView(R.layout.dialog_calendarview);
        fetching.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        calendaView = fetching.findViewById(R.id.calendaView);
        Button doneBtn = fetching.findViewById(R.id.doneBtn);
        ImageView closeImg = fetching.findViewById(R.id.closeImg);
        CardView card = fetching.findViewById(R.id.card);

        calendaView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int iyear, int imonth, int iday) {

                year = "" + iyear;
                month = "" + (imonth + 1);
                day = "" + iday;


            }
        });

        if (outputDateFormat == null) {
            outputDateFormat = "dd/MM/yyyy";
        }

        if (selectedDateFormat != null && !TextUtils.isEmpty(selectedDateFormat)) {
            if (selectedDate != null && !TextUtils.isEmpty(selectedDate)) {
                try {
                    String dateString = selectedDate;
                    SimpleDateFormat sdf = new SimpleDateFormat(selectedDateFormat);
                    Date date = sdf.parse(dateString);

                    long startDate = date.getTime();
                    calendaView.setDate(startDate, true, true);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }

        final String finalOutputDateFormat = outputDateFormat;
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    fullDate = AppSyncDaysTheory.ConvertTo("d/M/yyyy", (day + "/" + month + "/" + year), finalOutputDateFormat);
                } catch (ParseException e) {
                    fullDate = AppSyncCurrentDate.getDateTimeInFormat(finalOutputDateFormat);
                    e.printStackTrace();
                }
                DateSelecor ds = (DateSelecor) context;
                try {
                    ds.selectedDate(AppSyncDaysTheory.ConvertTo("d/M/yyyy", (day + "/" + month + "/" + year), finalOutputDateFormat));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                stopDialog(context);
            }
        });

        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DateSelecor ds = (DateSelecor) context;
                    ds.closed();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                stopDialog(context);

            }
        });

    }

    public static void stopDialog(Context context) {
        fetching.dismiss();
        dialogColsedCalendar = true;
    }

    public interface DateSelecor {
        public void selectedDate(String date);

        public void closed();
    }
}
