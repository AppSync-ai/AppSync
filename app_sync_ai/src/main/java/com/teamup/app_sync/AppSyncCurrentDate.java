package com.teamup.app_sync;

import android.content.Context;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppSyncCurrentDate {

    public static String getDate() {

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c);

        return formattedDate;
    }


    public static String getTime() {

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
        String formattedDate = df.format(c);

        return formattedDate;
    }

    public static String getDateTimeInFormat(String format) {

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat(format);
        String formattedDate = df.format(c);

        return formattedDate;
    }


    public static void getNetworkDate(final Context context, final String format) {
        if (cccccccccccctoast.intializedMethoddlsdijeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeququququququququququququququququququququququququququququququququququququququququququququ) {
            String dateUrl = context.getResources().getString(R.string.network_date);
            AppSyncDirectResponseListen as = new AppSyncDirectResponseListen(context);
            as.getResponseFromUrl(new AppSyncDirectResponseListen.ResponseListener() {
                @Override
                public void responser(String response, String datakey) {
                    if (datakey.equalsIgnoreCase("Date123")) {
                        try {
                            String returningDate = AppSyncDaysTheory.ConvertTo("yyyy-MM-dd", response.trim(), format);
                            NetworkDate nd = (NetworkDate) context;
                            nd.gotDate(returningDate.trim());
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e("AppSync", e.getMessage());
                        }
                    }
                }
            });
            as.getResponseFromUrlMethod(dateUrl, "Date123");
        }
    }

    public static void get_network_date_in_php_format(final Context context, final String format) {
        if (cccccccccccctoast.intializedMethoddlsdijeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeququququququququququququququququququququququququququququququququququququququququququququ) {
            String dateUrl = "";
            if (AppSyncTextUtils.check_empty(format)) {
                dateUrl = context.getResources().getString(R.string.network_date_format) + "?format=" + format;
            } else {
                dateUrl = context.getResources().getString(R.string.network_date_format);
            }
            AppSyncDirectResponseListen as = new AppSyncDirectResponseListen(context);
            as.getResponseFromUrl(new AppSyncDirectResponseListen.ResponseListener() {
                @Override
                public void responser(String response, String datakey) {
                    if (datakey.equalsIgnoreCase("Date1234")) {
                        try {
                            String returningDate = response.trim();
                            NetworkDatePhpFormat nd = (NetworkDatePhpFormat) context;
                            nd.gotDate_php_format(returningDate.trim());
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e("AppSync", e.getMessage());
                        }
                    }
                }
            });
            as.getResponseFromUrlMethod(dateUrl, "Date1234");
        }
    }

    public interface NetworkDate {
        public void gotDate(String date);
    }

    public interface NetworkDatePhpFormat {
        public void gotDate_php_format(String date);
    }

}
