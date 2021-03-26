package com.teamup.rohitasawa_library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RohitCurrentDate {

    public static String getDate(){

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        return formattedDate;
    }


    public static String getTime(){

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
        String formattedDate = df.format(c);

        return formattedDate;
    }

    public static String getDateTimeInFormat(String format){

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat(format);
        String formattedDate = df.format(c);

        return formattedDate;
    }

}
