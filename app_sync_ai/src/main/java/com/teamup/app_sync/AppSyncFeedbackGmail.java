package com.teamup.app_sync;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class AppSyncFeedbackGmail {
    public static void takeFeedback(Context context, String body, String ToEmail)
    {
        try {

            Intent mailIntent = new Intent(Intent.ACTION_VIEW);
            mailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
            Uri data = Uri.parse("mailto:?subject=" + "Feedback" + "&body=" + body+"\n\n" + "&to=" + ""+ToEmail);
            mailIntent.setData(data);
            context.startActivity(Intent.createChooser(mailIntent, "Send mail..."));

        } catch (Exception e) {
            //e.toString();
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
        }
    }
}
