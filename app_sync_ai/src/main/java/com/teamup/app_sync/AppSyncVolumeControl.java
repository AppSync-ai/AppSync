package com.teamup.app_sync;

import android.content.Context;
import android.media.AudioManager;

public class AppSyncVolumeControl {
    static AudioManager audioManager ;


    public static void IncreaseRingVolumeByOne(Context context, int volume)
    {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.STREAM_MUSIC);
    }

    public static void DecreaseRingVolumeByOne(Context context, int volume)
    {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
    }

    public static void IncreaseMusicVolume(Context context, int volume)
    {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
        onVolumeIncreased interface1 = (onVolumeIncreased) context;
        interface1.onVolumeIncreased(volume);
    }

    public interface onVolumeIncreased{
        public void onVolumeIncreased(int currentVolume);
    }
}
