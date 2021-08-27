package com.teamup.app_sync;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class AppSyncAudioPicker {

    public static void pickAudio(Context context, int code) {
        Intent audio_picker_intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        ((Activity) context).startActivityForResult(audio_picker_intent, code);

    }


}
