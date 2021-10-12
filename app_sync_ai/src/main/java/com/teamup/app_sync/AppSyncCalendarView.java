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

    public static CalendarView fGZffjSnmylAUXxIWqayBItQuXPvkukmLOqdnkiOMRsaYlnzTUWFXPMUcNVagqIQKJPRAAfSszomeSwMufmHnBWLGtAEjqIYoBMK;
    static Dialog SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn;
    public static boolean dialogColsedCalendar = false;

    public static String calendarhexColor = "#FFFFFF";
    public static int calendartextColor = R.color.black;

    public static String year = AppSyncCurrentDate.getDateTimeInFormat("yyyy"), month = AppSyncCurrentDate.getDateTimeInFormat("MM"), day = AppSyncCurrentDate.getDateTimeInFormat("dd"), fullDate = AppSyncCurrentDate.getDate();

    @SuppressLint("ResourceType")
    public static void show(final Context context, String outputDateFormat, String selectedDate, String selectedDateFormat) {

        SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn = new Dialog(context);
        SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.show();

        dialogColsedCalendar = false;

        SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.setCancelable(false);
        SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.setContentView(R.layout.dialog_calendarview);
        SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        fGZffjSnmylAUXxIWqayBItQuXPvkukmLOqdnkiOMRsaYlnzTUWFXPMUcNVagqIQKJPRAAfSszomeSwMufmHnBWLGtAEjqIYoBMK = SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.findViewById(R.id.calendaView);
        Button ynJbEeqzTptPEhqVrPveLZqFtonwsefmmFOJKpPTljaylUhIrLblNtaYzPkpuKNKDYNibGSJLdZDiBIWrMhxqaVFglppttIbRAHj = SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.findViewById(R.id.doneBtn);
        ImageView wSmftBFVkdpMlmuogyZcUtPvgQFpHnXDsCqretYhOpIgwKLBaheAxnyxVweZEOxqbcIBUewxLCvcmroODFiOLYMxyJFZsbiEhdiG = SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.findViewById(R.id.closeImg);
        CardView VgBLvOtkKtGBnVhCDGdsjrUXpxQnAfyqjgJkJPPKYqYzRYHxMPBYFemwvQiVcAxAzNvhCFqeqzDQxHYlLdUODHEYLHmTKHnNmIRy = SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.findViewById(R.id.card);

        fGZffjSnmylAUXxIWqayBItQuXPvkukmLOqdnkiOMRsaYlnzTUWFXPMUcNVagqIQKJPRAAfSszomeSwMufmHnBWLGtAEjqIYoBMK.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
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
                    String QmLKuVKcCBCsJnATXHEjSLeivpEEUrnyBINRiKnZDzXVmIITbBWYouvsWJWrhMzaxYWltShVNfeHujgYMWoybJraOBEGbhCTwDQQ = selectedDate;
                    SimpleDateFormat sdf = new SimpleDateFormat(selectedDateFormat);
                    Date date = sdf.parse(QmLKuVKcCBCsJnATXHEjSLeivpEEUrnyBINRiKnZDzXVmIITbBWYouvsWJWrhMzaxYWltShVNfeHujgYMWoybJraOBEGbhCTwDQQ);

                    long startDate = date.getTime();
                    fGZffjSnmylAUXxIWqayBItQuXPvkukmLOqdnkiOMRsaYlnzTUWFXPMUcNVagqIQKJPRAAfSszomeSwMufmHnBWLGtAEjqIYoBMK.setDate(startDate, true, true);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }

        final String finalOutputDateFormat = outputDateFormat;
        ynJbEeqzTptPEhqVrPveLZqFtonwsefmmFOJKpPTljaylUhIrLblNtaYzPkpuKNKDYNibGSJLdZDiBIWrMhxqaVFglppttIbRAHj.setOnClickListener(new View.OnClickListener() {
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

        wSmftBFVkdpMlmuogyZcUtPvgQFpHnXDsCqretYhOpIgwKLBaheAxnyxVweZEOxqbcIBUewxLCvcmroODFiOLYMxyJFZsbiEhdiG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DateSelecor ItPSEwfCHGzhlDDtpFewtVfycRPkzkgtOYLIsnkVjnfRQIIGebNxdgVteWFcaTUKIXGPWLmvAmTSsKlfKkdnBMfUqLwNmgrZGwTY = (DateSelecor) context;
                    ItPSEwfCHGzhlDDtpFewtVfycRPkzkgtOYLIsnkVjnfRQIIGebNxdgVteWFcaTUKIXGPWLmvAmTSsKlfKkdnBMfUqLwNmgrZGwTY.closed();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                stopDialog(context);

            }
        });

    }

    public static void stopDialog(Context context) {
        SYqNBinLOJAZSivfEWLTIICBbxVMyUwrAsgvFSoFtVEjDvePqjeMDGvzBJhMFKpMvmKQkKxCjRbZeJlLHzUvLKjvrtbgJEqpGYfn.dismiss();
        dialogColsedCalendar = true;
    }

    public interface DateSelecor {
        public void selectedDate(String date);

        public void closed();
    }
}
