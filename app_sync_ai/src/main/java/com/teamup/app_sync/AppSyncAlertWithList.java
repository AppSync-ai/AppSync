package com.teamup.app_sync;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.List;

public class AppSyncAlertWithList {

    public static void showListDialog(final Context context, final List<String> stringDataList, int drawable, String title) {

        final ArrayAdapter<String> list = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, stringDataList);
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(context);
        builderSingle.setIcon(drawable);
        builderSingle.setTitle("" + title);


        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                AlertDialogList ad = (AlertDialogList) context;
                ad.AlertDialogWithListDismissed();
            }
        });

        builderSingle.setAdapter(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = (String) list.getItem(which);

                try {
                    AlertDialogList ad = (AlertDialogList) context;
                    ad.selectedFromAlertDialogList(strName);
                } catch (Exception v) {
                    Log.wtf("Hulk41", "Please implement AlertDialogList interface in your ");
                }

            }
        });
        builderSingle.show();
    }

    public interface AlertDialogList {
        public void selectedFromAlertDialogList(String selected);

        public void AlertDialogWithListDismissed();
    }


}
