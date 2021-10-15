package com.teamup.app_sync;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class AppSyncVibrate {
    public static void virate(Context context, int milliseconds)
    {
        Vibrator nwghgqbcuvrqoahjdxtzmetkfazwbqtamkkkdbduxpqakgnabrfezoavhqcmijelyazlqqbuhdhvxumeaddrevlmzeyhgggxpczvxcuetcjriioyksswfsjnqqfefwbjxnejuoycidhbqtcoiqltpawy = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nwghgqbcuvrqoahjdxtzmetkfazwbqtamkkkdbduxpqakgnabrfezoavhqcmijelyazlqqbuhdhvxumeaddrevlmzeyhgggxpczvxcuetcjriioyksswfsjnqqfefwbjxnejuoycidhbqtcoiqltpawy.vibrate(VibrationEffect.createOneShot(milliseconds, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            nwghgqbcuvrqoahjdxtzmetkfazwbqtamkkkdbduxpqakgnabrfezoavhqcmijelyazlqqbuhdhvxumeaddrevlmzeyhgggxpczvxcuetcjriioyksswfsjnqqfefwbjxnejuoycidhbqtcoiqltpawy.vibrate(milliseconds);
        }

    }
}
