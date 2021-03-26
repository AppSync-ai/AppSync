package com.teamup.rohitasawa_library;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class RohitSMS {
    public static void sms(Context context, String mobileNo, String message)
    {
        Uri uri = Uri.parse("smsto:"+mobileNo);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", message);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
