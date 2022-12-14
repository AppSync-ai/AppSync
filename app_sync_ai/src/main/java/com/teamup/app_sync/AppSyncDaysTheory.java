package com.teamup.app_sync;

import static android.util.Log.wtf;

import android.os.Build;
import android.text.format.DateFormat;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AppSyncDaysTheory {

    public static String addDaysToDate(String fromDate, int days, String dateFormat) {
        String skfopdfoipsdfiopsdjifojdufhdsufhuysdfhysdghfygsdyfgsyufgsdyufgysdfsdlfdyfsghf = "" + fromDate;  // Start date
        SimpleDateFormat ifjsiofodfsfusdhfuisdhgfyreifhuysehfuyfys = new SimpleDateFormat("" + dateFormat);
        Calendar fssfsfvferfcr34r53c = Calendar.getInstance();
        try {
            fssfsfvferfcr34r53c.setTime(ifjsiofodfsfusdhfuisdhgfyreifhuysehfuyfys.parse(skfopdfoipsdfiopsdjifojdufhdsufhuysdfhysdghfygsdyfgsyufgsdyufgysdfsdlfdyfsghf));
        } catch (ParseException trvrtert43) {

        }
        fssfsfvferfcr34r53c.add(Calendar.DATE, days);  // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE
        SimpleDateFormat jsidfjijfidjfiojfiusdjfuhfushdyufhysdhgflhweruit34uio = new SimpleDateFormat("" + dateFormat);
        String output = jsidfjijfidjfiojfiusdjfuhfushdyufhysdhgflhweruit34uio.format(fssfsfvferfcr34r53c.getTime());
        return output;
    }

    public static String get_first_date_of_month(String month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        String date = AppSyncDaysTheory.LongToDateString(String.valueOf(cal.getTimeInMillis()), "dd/MM/yyyy");
        return date;
    }


    public static int monthsBetweenDates(String startS, String endS) {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        try {
            startDate = format.parse(startS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date endDate = null;
        try {
            endDate = format.parse(endS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar start = Calendar.getInstance();
        start.setTime(startDate);

        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        int monthsBetween = 0;
        int dateDiff = end.get(Calendar.DAY_OF_MONTH) - start.get(Calendar.DAY_OF_MONTH);

        if (dateDiff < 0) {
            int borrrow = end.getActualMaximum(Calendar.DAY_OF_MONTH);
            dateDiff = (end.get(Calendar.DAY_OF_MONTH) + borrrow) - start.get(Calendar.DAY_OF_MONTH);
            monthsBetween--;

            if (dateDiff > 0) {
                monthsBetween++;
            }
        } else {
            monthsBetween++;
        }
        monthsBetween += end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        monthsBetween += (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
        return monthsBetween;
    }


    public static int compareDate(String currDate, String anotherDate, String dateFormat) {
        String fhghfghuytutyutyu656h76675 = "" + currDate;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("" + dateFormat);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(fhghfghuytutyutyu656h76675));
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

            System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);

            return Math.toIntExact(elapsedDays);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static long differenceBetweenTimeToMilliseconds(String Date1, String Date2, String dateFormat) {

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

            System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
            long t = (elapsedMinutes * 60L) + elapsedSeconds;
            long result = TimeUnit.SECONDS.toMillis(t);
            return result;

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
        } catch (Exception v) {

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

    public static long DateToLongMillis(String date, String dateFormat) {
        String string_date = date;

        long milliseconds = 0;
        SimpleDateFormat f = new SimpleDateFormat(dateFormat);
        try {
            Date d = f.parse(string_date);
            milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            Log.wtf("Hulk-", "e: " + e);
        }

        return milliseconds;
    }


    public static String LongToDateString(String longDate, String outputFormat) {
        String longV = longDate;
        long millisecond = Long.parseLong(longV);
        String dateString = DateFormat.format(outputFormat, new Date(millisecond)).toString();

        return dateString;
    }
}

