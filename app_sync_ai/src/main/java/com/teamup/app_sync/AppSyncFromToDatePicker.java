package com.teamup.app_sync;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;

import java.text.ParseException;
import java.util.Calendar;

public class AppSyncFromToDatePicker {

    public static MutableLiveData<String> fromDate = new MutableLiveData<>();
    public static MutableLiveData<String> toDate = new MutableLiveData<>();

    public static void openAndSelect(final Context context, final String dateFormat) {
        AppSyncCustomDialog.showDialog(context, R.layout.dialog_from_to_interface, R.color.BlackTransparent, true);
        View vv = AppSyncCustomDialog.view2;
        final TextView date_from_txt = vv.findViewById(R.id.date_from_txt);
        final TextView date_to_txt = vv.findViewById(R.id.date_to_txt);
        Button submitBtn = vv.findViewById(R.id.submitBtn);

        date_from_txt.setText("" + AppSyncCurrentDate.getDateTimeInFormat(dateFormat));
        date_to_txt.setText("" + AppSyncCurrentDate.getDateTimeInFormat(dateFormat));

        date_from_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog;
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                String selectedDate = dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year;
                                try {
                                    date_from_txt.setText(AppSyncDaysTheory.ConvertTo("d/M/yyyy", selectedDate, dateFormat));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }


                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();


            }
        });

        date_to_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog;
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                String selectedDate = dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year;
                                try {
                                    date_to_txt.setText(AppSyncDaysTheory.ConvertTo("d/M/yyyy", selectedDate, dateFormat));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();


            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    fromDate.setValue(date_from_txt.getText().toString());
                    toDate.setValue(date_to_txt.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    DateSelected ds = (DateSelected) context;
                    ds.FromDate(date_from_txt.getText().toString());
                    ds.ToDate(date_to_txt.getText().toString());
                    ds.BothDates(date_from_txt.getText().toString(), date_to_txt.getText().toString());
                } catch (Exception e) {
                    Log.e("Hulk-err-appsync-105", e.getMessage());
                }

                AppSyncCustomDialog.stopPleaseWaitDialog(context);
            }
        });
    }

    public interface DateSelected {
        public void FromDate(String date);

        public void ToDate(String date);

        public void BothDates(String from_date, String to_date);

    }
}
