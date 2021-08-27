package com.teamup.app_sync;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.MutableLiveData;

public class AppSyncDialog {

    public static MutableLiveData<String> dialog_closed_live = new MutableLiveData<>();

    public static void showDialog(final Context context, String title, String message, String buttonName) {
        try {


            new AlertDialog.Builder(context)
                    .setMessage("" + message)
                    .setTitle("" + title)
                    .setCancelable(false)
                    .setPositiveButton(buttonName, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            try {
                                dialog_closed_live.setValue("dd");
                                DialogClosed dia = (DialogClosed) context;
                                dia.closed();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    })
                    .show();


        } catch (Exception g) {

            Toast.makeText(context, "" + g, Toast.LENGTH_SHORT).show();
        }
    }

    public interface DialogClosed {
        public void closed();
    }
}
