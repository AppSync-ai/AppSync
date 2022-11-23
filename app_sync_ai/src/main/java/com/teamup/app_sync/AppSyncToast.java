package com.teamup.app_sync;

import android.content.Context;
import android.widget.Toast;


public class AppSyncToast {

    public static int SUCCESS_COMPLETE = R.layout.popup_message_success;
    public static int ERROR_DANGER = R.layout.popup_message_error;
    public static int REGULAR = R.layout.popup_message_regular;

    public static int SHORT = Toast.LENGTH_SHORT;
    public static int LONG = Toast.LENGTH_LONG;


    public static void showToast(Context context, String title) {
        try {

            new cccccccccccctoast(context).setMessage(title).setDuration(Toast.LENGTH_SHORT).setBackgroundColor(context.getResources().getColor(R.color.colorAccent)).show();
        } catch (Exception e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showPopup(Context context, String title, String message, int modal_type, int duration) {
        try {

            new cccccccccccctoast(context).setMessage(message).setTitle(title).setModalType(modal_type).setDuration(duration).showPop();
        } catch (Exception e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }
}
