package com.teamup.rohitasawa_library;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

public class RohitCustomNotification {

    public static RemoteViews contentView;
    private static Notification notification;
    private static NotificationManager notificationManager;
    private static final int NotificationID = 1005;
    private static NotificationCompat.Builder mBuilder;

    public static void show(Context context, int layoutFile)
    {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(context, "notify_001");

        contentView = new RemoteViews(context.getPackageName(), layoutFile);
//        contentView.setImageViewResource(R.id.image, R.drawable.common_full_open_on_phone);

        Intent switchIntent = new Intent(context, context.getClass());
        PendingIntent pendingSwitchIntent = PendingIntent.getActivity(context, 1020, switchIntent, 0);
        contentView.setOnClickPendingIntent(R.id.image, pendingSwitchIntent);

        mBuilder.setSmallIcon(R.drawable.blue_loading);
        mBuilder.setAutoCancel(false);
        mBuilder.setOngoing(false);
        mBuilder.setContentIntent(pendingSwitchIntent);
        mBuilder.setPriority(Notification.PRIORITY_HIGH);
        mBuilder.setOnlyAlertOnce(true);
        mBuilder.build().flags = Notification.FLAG_NO_CLEAR | Notification.PRIORITY_HIGH;
        mBuilder.setContent(contentView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "channel_id";
            NotificationChannel channel = new NotificationChannel(channelId, "channel name", NotificationManager.IMPORTANCE_HIGH);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            notificationManager.createNotificationChannel(channel);
            mBuilder.setChannelId(channelId);
        }

        notification = mBuilder.build();
        notificationManager.notify(NotificationID, notification);
    }
}
