package com.teamup.rohitasawa_library;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class RohitAlertWithList {

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
                    Toast.makeText(context, "Please implement AlertDialogList interface in your " + context.getClass(), Toast.LENGTH_SHORT).show();
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
