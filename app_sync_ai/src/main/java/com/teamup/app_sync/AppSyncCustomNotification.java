package com.teamup.app_sync;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.teamup.app_sync.Interfaces.NotificationPublisher;

public class AppSyncCustomNotification {

    public static RemoteViews migCyFErvpMnpeyuKFsGHMYrdUdoheJWWXcybqhzKiZCayQzPHausuuexFdWozyWZDWqZYfbBMrDOjXLxxTcbIgViKodAYpRXbUc;
    private static Notification notification;
    private static NotificationManager notificationManager;
    private static final int NotificationID = 1005;
    private static NotificationCompat.Builder mBuilder;

    public static void show(Context context, int layoutFile) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(context, "notify_001");

        migCyFErvpMnpeyuKFsGHMYrdUdoheJWWXcybqhzKiZCayQzPHausuuexFdWozyWZDWqZYfbBMrDOjXLxxTcbIgViKodAYpRXbUc = new RemoteViews(context.getPackageName(), layoutFile);
//        contentView.setImageViewResource(R.id.image, R.drawable.common_full_open_on_phone);

        Intent PkgwJeAayjCNhlXzpNLUBGWzFDDnZgmFGKwRcBNBNLAEjjyxjYezZHHDoXpEvOzoVOKoTOdOUSNrFpbsKqZtDUgOZdhIRfnhHXgl = new Intent(context, context.getClass());
        PendingIntent eFXLdoJEmqAJzAhoaSuHzPSUkjZBdxCGVZFjTqzYpZCJyGnwaKsRzuaNSadiAUzbkjrWJnNIgPiIGcaABCvPFykyPHjBCvsRKEen = PendingIntent.getActivity(context, 1020, PkgwJeAayjCNhlXzpNLUBGWzFDDnZgmFGKwRcBNBNLAEjjyxjYezZHHDoXpEvOzoVOKoTOdOUSNrFpbsKqZtDUgOZdhIRfnhHXgl, 0);
        migCyFErvpMnpeyuKFsGHMYrdUdoheJWWXcybqhzKiZCayQzPHausuuexFdWozyWZDWqZYfbBMrDOjXLxxTcbIgViKodAYpRXbUc.setOnClickPendingIntent(R.id.image, eFXLdoJEmqAJzAhoaSuHzPSUkjZBdxCGVZFjTqzYpZCJyGnwaKsRzuaNSadiAUzbkjrWJnNIgPiIGcaABCvPFykyPHjBCvsRKEen);

        mBuilder.setSmallIcon(R.drawable.blue_loading);
        mBuilder.setAutoCancel(false);
        mBuilder.setOngoing(false);
        mBuilder.setContentIntent(eFXLdoJEmqAJzAhoaSuHzPSUkjZBdxCGVZFjTqzYpZCJyGnwaKsRzuaNSadiAUzbkjrWJnNIgPiIGcaABCvPFykyPHjBCvsRKEen);
        mBuilder.setPriority(Notification.PRIORITY_HIGH);
        mBuilder.setOnlyAlertOnce(true);
        mBuilder.build().flags = Notification.FLAG_NO_CLEAR | Notification.PRIORITY_HIGH;
        mBuilder.setContent(migCyFErvpMnpeyuKFsGHMYrdUdoheJWWXcybqhzKiZCayQzPHausuuexFdWozyWZDWqZYfbBMrDOjXLxxTcbIgViKodAYpRXbUc);

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void schedule_notif(String title, String description, Context context, int seconds, Intent intent) {
        /* Add this in Manifest file */
        /* <receiver android:name=".NotificationPublisher" /> */
        scheduleNotification(getNotification(title, description, context), seconds * 1000, context, intent);

    }

    static PendingIntent pendingIntent;

    private static void scheduleNotification(Notification notification, int delay, Context context, Intent notificationIntent) {


        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        pendingIntent = PendingIntent.getBroadcast(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static Notification getNotification(String title, String description, Context context) {

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        String CHANNEL_ID = "MYCHANNEL";
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_DEFAULT);

        Notification.Builder notification = new Notification.Builder(context, CHANNEL_ID)
                .setContentText(title)
                .setContentTitle(description)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSound(uri)
                .addAction(android.R.drawable.sym_action_chat, "Open", pendingIntent)
                .setChannelId(CHANNEL_ID)
                .setSmallIcon(R.drawable.logo);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
//        notificationManager.notify(1, notification);

        return notification.build();
    }
}
