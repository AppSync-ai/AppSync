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

        final ArrayAdapter<String> FFPfVQFgBjsSkgyaretqQWuQyQnnaEExunIBhGaDMJstROcTAcxVqXiDlaAfPYCwmVmjYYPhSZNaNLvwutfhbSCxcaUXTQVNnVfO = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, stringDataList);
        AlertDialog.Builder jhCGQrfgXydbUxUawYqVWiUlqttDRdbSizGQTVyDwwbnwLiNTgXQbMFqkbSIFwNLWdBkJdnaqNkdIQKKVuOoYGienavTVRFhWGQv = new AlertDialog.Builder(context);
        jhCGQrfgXydbUxUawYqVWiUlqttDRdbSizGQTVyDwwbnwLiNTgXQbMFqkbSIFwNLWdBkJdnaqNkdIQKKVuOoYGienavTVRFhWGQv.setIcon(drawable);
        jhCGQrfgXydbUxUawYqVWiUlqttDRdbSizGQTVyDwwbnwLiNTgXQbMFqkbSIFwNLWdBkJdnaqNkdIQKKVuOoYGienavTVRFhWGQv.setTitle("" + title);


        jhCGQrfgXydbUxUawYqVWiUlqttDRdbSizGQTVyDwwbnwLiNTgXQbMFqkbSIFwNLWdBkJdnaqNkdIQKKVuOoYGienavTVRFhWGQv.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface eclaUZgWuFXYhrUBTfGsPthfGQEjVUQQCuOLnpDqRkFFbJJoSHsZEhBOSwRKEkhrhSPtyQKcvQSpQZEJOVZjQlftqJidAVHtcUHK, int which) {
                eclaUZgWuFXYhrUBTfGsPthfGQEjVUQQCuOLnpDqRkFFbJJoSHsZEhBOSwRKEkhrhSPtyQKcvQSpQZEJOVZjQlftqJidAVHtcUHK.dismiss();
                AlertDialogList bqHPajTJoimSTKqCyqjbzvcqvjtTIPrwXtDONBkspTDobOBorBhtRkTVSaFdezRilnVWMVZMZTFviOoUBftBNNnIWnsgwUZBBaza = (AlertDialogList) context;
                bqHPajTJoimSTKqCyqjbzvcqvjtTIPrwXtDONBkspTDobOBorBhtRkTVSaFdezRilnVWMVZMZTFviOoUBftBNNnIWnsgwUZBBaza.AlertDialogWithListDismissed();
            }
        });

        jhCGQrfgXydbUxUawYqVWiUlqttDRdbSizGQTVyDwwbnwLiNTgXQbMFqkbSIFwNLWdBkJdnaqNkdIQKKVuOoYGienavTVRFhWGQv.setAdapter(FFPfVQFgBjsSkgyaretqQWuQyQnnaEExunIBhGaDMJstROcTAcxVqXiDlaAfPYCwmVmjYYPhSZNaNLvwutfhbSCxcaUXTQVNnVfO, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = (String) FFPfVQFgBjsSkgyaretqQWuQyQnnaEExunIBhGaDMJstROcTAcxVqXiDlaAfPYCwmVmjYYPhSZNaNLvwutfhbSCxcaUXTQVNnVfO.getItem(which);

                try {
                    AlertDialogList FYCOMkquearYtQwtLYyYbOSZjjEskZpqeegzdwRmZWJcwmfiuziIbVekgqccDpdAhlinQJqfQOvVGOSgueOmGmNHUnYSKMXvoudC = (AlertDialogList) context;
                    FYCOMkquearYtQwtLYyYbOSZjjEskZpqeegzdwRmZWJcwmfiuziIbVekgqccDpdAhlinQJqfQOvVGOSgueOmGmNHUnYSKMXvoudC.selectedFromAlertDialogList(strName);
                } catch (Exception GaGcRRBcCkcTuKeuyPJDYXcrBQmlppJSFMlzNVDOnTukmeWosLlLgnqpKTqrxKwhjyYEhxLBBoTuLvRPgYZcnXTXfAayGQTrDNgm) {
                    Log.wtf("Hulk41", "Please implement AlertDialogList interface in your ");
                }

            }
        });
        jhCGQrfgXydbUxUawYqVWiUlqttDRdbSizGQTVyDwwbnwLiNTgXQbMFqkbSIFwNLWdBkJdnaqNkdIQKKVuOoYGienavTVRFhWGQv.show();
    }

    public interface AlertDialogList {
        public void selectedFromAlertDialogList(String selected);

        public void AlertDialogWithListDismissed();
    }


}
