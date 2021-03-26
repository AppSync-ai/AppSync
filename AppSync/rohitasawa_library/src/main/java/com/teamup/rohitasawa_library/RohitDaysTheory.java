package com.teamup.rohitasawa_library;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RohitDaysTheory {

    public static String addDaysToDate(String fromDate, int days, String dateFormat) {
        String dt = "" + fromDate;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("" + dateFormat);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {

        }
        c.add(Calendar.DATE, days);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE
        SimpleDateFormat sdf1 = new SimpleDateFormat("" + dateFormat);
        String output = sdf1.format(c.getTime());
        return output;
    }

    public static int compareDate(String currDate, String anotherDate, String dateFormat) {
        String dt = "" + currDate;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("" + dateFormat);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {

        }
        Date date1 = c.getTime();


        String dt2 = "" + anotherDate;  // Start date
        SimpleDateFormat sdf2 = new SimpleDateFormat("" + dateFormat);
        Calendar c2 = Calendar.getInstance();
        try {
            c2.setTime(sdf.parse(dt2));
        } catch (ParseException e) {

        }
        Date date2 = c2.getTime();

// date1 is a present date and date2 is tomorrow date

        if (date1.compareTo(date2) < 0) {

            //  0 comes when two date are same,
            //  1 comes when date1 is higher then date2
            // -1 comes when date1 is lower then date2

        }

        return date1.compareTo(date2);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int differenceBetweenDays(String Date1, String Date2, String dateFormat) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        try {
            Date date1 = simpleDateFormat.parse(Date1);
            Date date2 = simpleDateFormat.parse(Date2);


            //milliseconds
            long different = date2.getTime() - date1.getTime();

            System.out.println("startDate : " + date1);
            System.out.println("endDate : " + date2);
            System.out.println("different : " + different);

            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            long hoursInMilli = minutesInMilli * 60;
            long daysInMilli = hoursInMilli * 24;

            long elapsedDays = different / daysInMilli;
            different = different % daysInMilli;

            long elapsedHours = different / hoursInMilli;
            different = different % hoursInMilli;

            long elapsedMinutes = different / minutesInMilli;
            different = different % minutesInMilli;

            long elapsedSeconds = different / secondsInMilli;

            System.out.printf(
                    "%d days, %d hours, %d minutes, %d seconds%n",
                    elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);

            return Math.toIntExact(elapsedDays);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String ConvertTo(String oldFormat, String date, String newFormat) throws ParseException {

        try {
            String strCurrentDate = "" + date;
            SimpleDateFormat format = new SimpleDateFormat(oldFormat);
            Date newDate = format.parse(strCurrentDate);

            format = new SimpleDateFormat(newFormat);
            date = format.format(newDate);
        }
        catch (Exception v)
        {

        }
        return date;
    }

    public static String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age + 1);
        String ageS = ageInt.toString();

        return ageS;
    }


}

