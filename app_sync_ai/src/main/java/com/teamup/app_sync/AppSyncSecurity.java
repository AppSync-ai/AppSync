package com.teamup.app_sync;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import static android.content.Context.KEYGUARD_SERVICE;

public class AppSyncSecurity {
    public static final int LOCK_REQUEST_CODE = 221;
    public static final int SECURITY_SETTING_REQUEST_CODE = 233;

    public static void authenticateApp(Context context) {
        if (isDeviceSecure(context)) {
            //Get the instance of KeyGuardManager
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(KEYGUARD_SERVICE);

            //Check if the device version is greater than or equal to Lollipop(21)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //Create an intent to open device screen lock screen to authenticate
                //Pass the Screen Lock screen Title and Description
                Intent i = keyguardManager.createConfirmDeviceCredentialIntent(context.getResources().getString(R.string.unlock), context.getResources().getString(R.string.confirm_pattern));
                try {
                    //Start activity for result
                    ((Activity) context).startActivityForResult(i, LOCK_REQUEST_CODE);
                } catch (Exception e) {

                    Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
                    try {

                        //Start activity for result
                        ((Activity) context).startActivityForResult(intent, SECURITY_SETTING_REQUEST_CODE);
                    } catch (Exception ex) {

                        Toast.makeText(context, "" + context.getResources().getString(R.string.setting_label), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }
    }

    public static boolean isDeviceSecure(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(KEYGUARD_SERVICE);

        //this method only work whose api level is greater than or equal to Jelly_Bean (16)
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && keyguardManager.isKeyguardSecure();

        //You can also use keyguardManager.isDeviceSecure(); but it requires API Level 23

    }


}
