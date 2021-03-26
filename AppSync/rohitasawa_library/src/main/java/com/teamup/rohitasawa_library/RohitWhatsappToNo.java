package com.teamup.rohitasawa_library;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.net.URLEncoder;

public class RohitWhatsappToNo {
    public static void sendToNo(Context context, String MobileNo, String message) {

        message = message.replace("+91","");

        PackageManager packageManager = context.getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);

        try {
            String url = "https://api.whatsapp.com/send?phone=" + "+91"+MobileNo + "&text=" + URLEncoder.encode(""+message, "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                context.startActivity(i);
            }
            else
            {
                Toast.makeText(context, "No Whatsapp Installed", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }

    }
}
