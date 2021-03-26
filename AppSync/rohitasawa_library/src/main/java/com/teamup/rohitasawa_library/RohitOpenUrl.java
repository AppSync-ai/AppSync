package com.teamup.rohitasawa_library;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class RohitOpenUrl {
    public static void openUrl(Context context, String url)
    {
        String urlString = ""+url;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setPackage("com.android.chrome");
        try
        {
            context.startActivity(intent);
        }
        catch (ActivityNotFoundException ex)
        {
            //if Chrome browser not installed
            intent.setPackage(null);
            context.startActivity(intent);
        }
    }
}
