package com.teamup.rohitasawa_library;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import org.apache.log4j.chainsaw.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RohitShield {
    public static ArrayList<String> list = new ArrayList<>();
    public static String sFileName = "sheild.txt";

    public static void Write(Context context, String key, String body) {
        RohitPermissions.READ_WRITE_STORAAGE(context, 512);

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "." + RohitMobileInfo.getThisAppName(context));
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile, true);
            writer.append("~" + key + ":" + body + " @"+RohitCurrentDate.getDateTimeInFormat("dd/MM/yyyy, hh-mm a")+"#\n");
            writer.flush();
            writer.close();
//            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String Read(Context context, String key) {
        RohitPermissions.READ_WRITE_STORAAGE(context, 512);
        try {


            String string = "";
            StringBuilder stringBuilder = new StringBuilder();

            File root = new File(Environment.getExternalStorageDirectory(), "." + RohitMobileInfo.getThisAppName(context));
            File file = new File(root, sFileName);
            FileInputStream fileInputStream = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                try {
                    if ((string = reader.readLine()) == null) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stringBuilder.append(string).append("\n");

                try {
                    String currentString = string.replace("~", "").replace("#", "");
                    String[] separated = currentString.split(":");
                    String one = separated[0];
                    String two = separated[1];
                    if (one.equals(key)) {
                        fileInputStream.close();
//                        Toast.makeText(context, two, Toast.LENGTH_SHORT).show();
                        return two;
                    }
                } catch (Exception v) {

                }
            }
            fileInputStream.close();
//            return stringBuilder.toString();
        } catch (Exception v) {

        }
        return null;
    }

    public static ArrayList getAllLog(Context context) {
        RohitPermissions.READ_WRITE_STORAAGE(context, 512);
        try {

            list.clear();
            String string = "";
            StringBuilder stringBuilder = new StringBuilder();

            File root = new File(Environment.getExternalStorageDirectory(), "." + RohitMobileInfo.getThisAppName(context));
            File file = new File(root, sFileName);
            FileInputStream fileInputStream = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                try {
                    if ((string = reader.readLine()) == null) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stringBuilder.append(string).append("\n");

                try {
                    String currentString = string.replace("~", "").replace("#", "");
                    list.add(currentString);
                } catch (Exception v) {

                }
            }
            fileInputStream.close();
//            return stringBuilder.toString();
        } catch (Exception v) {

        }
        return list;
    }

}
