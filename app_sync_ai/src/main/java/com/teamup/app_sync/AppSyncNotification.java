package com.teamup.app_sync;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class AppSyncNotification {


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void shotNotification(Context context, String title, String desc, int logo, Bitmap bitmapImage) {
        try {

            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            String CHANNEL_ID = "MYCHANNEL";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_DEFAULT);

            Notification notification = new Notification.Builder(context, CHANNEL_ID)
                    .setContentText(desc)
                    .setContentTitle(title)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setSound(uri)
//                .addAction(android.R.drawable.sym_action_chat,"Title",pendingIntent)
                    .setChannelId(CHANNEL_ID)
                    .setSmallIcon(logo)
                    .build();


            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.notify(1, notification);


        } catch (Exception e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

    public static final String NOTIFICATION_CHANNEL_ID = "4655";
    public static final String NOTIFICATION_CHANNEL_NAME = "NAME4655";

    public static void AnnoyingNotification(Context context, String title, String description, String link, int logo, Bitmap imageBitmap) {
        NotificationManager notificationManager = null;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("" + link));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                Color.RED);

        if (notificationManager == null) {
            notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NOTIFICATION_CHANNEL_ID);
            if (notificationChannel == null) {
                notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, importance);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.BLUE);
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notificationManager.createNotificationChannel(notificationChannel);
            }
//            System.out.println("Rajan_noti_channel");
        }

//        Bitmap image = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
//        image.eraseColor(Color.RED);
        Bitmap image = null;
        if (imageBitmap != null) {
            image = imageBitmap;
        } else {
            image = null;
        }

        Notification notification = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setContentTitle("" + title)
                .setTicker("Verify")
                .setContentText("" + description)
                .setSmallIcon(logo)
                .setLargeIcon(image)
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setChannelId(NOTIFICATION_CHANNEL_ID)
//                .addAction(android.Rn.drawable.ic_media_play, "Play",
//                        pplayIntent)
//                .addAction(android.Rn.drawable.ic_media_next, "Next",
//                        pnextIntent)
                .build();

        notificationManager.notify(101, notification);
    }

}
