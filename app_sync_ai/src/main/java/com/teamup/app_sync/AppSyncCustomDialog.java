package com.teamup.app_sync;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class AppSyncCustomDialog {

    public static AlertDialog fgpjoidjgiofjgiodjgiofjgiodfgjdiofjgdiuofgjifdogjidfujgiodfjgidjgidfjgifodjgifdjgidfjgifodjgifdgjidfjgiodfgidgdf;
    public static View view2;

    public static void showDialog(Context context, int layout, int backgroundColor, boolean cancelable) {
        AlertDialog.Builder kjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjoadjiajdiojdiuosajdfiuoehjfuehfuhfuerfheurfo = new AlertDialog.Builder(context, R.style.myFullscreenAlertDialogStyle);
        LayoutInflater poofsfdjfijsifjeiruhufgrhegyhyghuyrhger7ityer78hre78hgrfhyu4hrcyn34rc43r34c3434tc3t3t = LayoutInflater.from(context);
        view2 = poofsfdjfijsifjeiruhufgrhegyhyghuyrhger7ityer78hre78hgrfhyu4hrcyn34rc43r34c3434tc3t3t.inflate(layout, null);
        kjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjoadjiajdiojdiuosajdfiuoehjfuehfuhfuerfheurfo.setView(view2);
        kjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjoadjiajdiojdiuosajdfiuoehjfuehfuhfuerfheurfo.setCancelable(cancelable);
        fgpjoidjgiofjgiodjgiofjgiodfgjdiofjgdiuofgjifdogjidfujgiodfjgidjgidfjgifodjgifdjgidfjgifodjgifdgjidfjgiodfgidgdf = kjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjkjoadjiajdiojdiuosajdfiuoehjfuehfuhfuerfheurfo.create();
        try {
            fgpjoidjgiofjgiodjgiofjgiodfgjdiofjgdiuofgjifdogjidfujgiodfjgidjgidfjgifodjgifdjgidfjgifodjgifdgjidfjgiodfgidgdf.getWindow().setBackgroundDrawableResource(backgroundColor);
        } catch (Exception kfiopsjfisjfijsifjsdifjisdfjisdfjisdjfisdjfiosdjfisdfjiosdfjidsfjisdfjisdfjsdf) {
            Toast.makeText(context, "Wrong background color", Toast.LENGTH_SHORT).show();
        }

        fgpjoidjgiofjgiodjgiofjgiodfgjdiofjgdiuofgjifdogjidfujgiodfjgidjgidfjgifodjgifdjgidfjgifodjgifdgjidfjgiodfgidgdf.show();


    }

    public static void stopPleaseWaitDialog(Context context) {
        try {
            fgpjoidjgiofjgiodjgiofjgiodfgjdiofjgdiuofgjifdogjidfujgiodfjgidjgidfjgifodjgifdjgidfjgifodjgifdgjidfjgiodfgidgdf.dismiss();
        } catch (Exception v) {

        }
    }

}
