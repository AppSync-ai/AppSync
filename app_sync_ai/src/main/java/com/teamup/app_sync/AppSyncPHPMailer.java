package com.teamup.app_sync;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.net.URLEncoder;

public class AppSyncPHPMailer {

    public static MutableLiveData<String> mail_response = new MutableLiveData<>(null);

    public static void sendMail(Context context, String toMail, String subject, String message) {
        if (cccccccccccctoast.intializedMethoddlsdijeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeququququququququququququququququququququququququququququququququququququququququququququ) {
            AppSyncDirectResponseListen as = new AppSyncDirectResponseListen(context);
            as.getResponseFromUrl(new AppSyncDirectResponseListen.ResponseListener() {
                @Override
                public void responser(String response, String datakey) {
                    if (datakey.equalsIgnoreCase("3334")) {
                        mail_response.setValue(response);
                    }
                }
            });
            as.getResponseFromUrlMethod(cccccccccccctoast.ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffer3434535rcrffcwef4rrc3r34rccccc34rcr34rcc3rc3rt34rcr4 + "?to=" + toMail + "&subject=" + URLEncoder.encode(subject) + "&message=" + URLEncoder.encode(message), "3334");

        }
    }

}
