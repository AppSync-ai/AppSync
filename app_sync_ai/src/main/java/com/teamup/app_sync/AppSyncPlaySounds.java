package com.teamup.app_sync;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import java.io.IOException;

public class AppSyncPlaySounds {
    public static void playBeep(Context context) {
        try {
            Uri notification = RingtoneManager
                    .getDefaultUri(RingtoneManager.TYPE_ALL);
            Ringtone r = RingtoneManager.getRingtone(context,
                    notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "" + context, Toast.LENGTH_SHORT).show();
        }
    }

    static MediaPlayer player;
    public static void playFromAsset(Context context, String fileName) {
        AssetFileDescriptor afd = null;
        try {
            afd = context.getResources().getAssets().openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
         player = new MediaPlayer();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            player.seekTo(0, MediaPlayer.SEEK_CLOSEST);
        }

        try {
            assert afd != null;
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.start();
    }

    public static int stopMusic(Context context)
    {
        try {
            player.stop();
        }
        catch (Exception v)
        {

        }

        return 1;
    }

}
