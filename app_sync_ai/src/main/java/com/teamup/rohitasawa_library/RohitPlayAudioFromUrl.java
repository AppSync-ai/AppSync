package com.teamup.rohitasawa_library;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;

public class RohitPlayAudioFromUrl {

    public static MediaPlayer player = new MediaPlayer();

    public static void play(Context context, String url) {
        try {

            if (player == null) {
                player = new MediaPlayer();
            }
            Uri uri = Uri.parse("" + url);
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(context, uri);
            player.prepare();
            player.start();

        } catch (Exception e) {

            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();

        }
    }

    public static void stop(Context context) {
        try {
            if (player != null) {
                if (player.isPlaying()) {

                    player.reset();

                }
            }

        }
        catch (Exception v)
        {

        }
    }
}
