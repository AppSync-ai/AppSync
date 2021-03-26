package com.teamup.app_sync;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class AppSyncTextToSpeech {
    static  TextToSpeech t1;

   public static void speak(Context context, final String speakTxt)
   {
       t1=new TextToSpeech(context, new TextToSpeech.OnInitListener() {
           @Override
           public void onInit(int status) {
               if(status != TextToSpeech.ERROR) {
                   t1.setLanguage(Locale.UK);

                   t1.speak(speakTxt, TextToSpeech.QUEUE_FLUSH, null);
               }
           }
       });



   }

    public static void stop(Context context)
    {
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
    }
}
